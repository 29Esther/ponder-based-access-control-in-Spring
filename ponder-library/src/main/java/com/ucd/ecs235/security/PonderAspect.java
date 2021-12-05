package com.ucd.ecs235.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucd.ecs235.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class PonderAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DefaultService defaultService;

    private final ObjectMapper objectMapper;

    @Value("${spring.security.oauth2.resourceserver.jwt.client-id}")
    private String clientId;

    @Pointcut("within(@EnablePonderCheck *)")
    public void PonderCheckClassMethods() {
    }

    @Before("PonderCheckClassMethods()")
    public void logPonderCheckClassMethods(JoinPoint jp) throws JsonProcessingException {
        String methodName = jp.getSignature().getName();
        String[] classPath = jp.getSignature().getDeclaringTypeName().split("\\.");
        String className = classPath[classPath.length - 1];
        logger.info("Before " + methodName + "in " + className);

        logger.debug("enter PonderMethodInterceptor");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            logger.error("Something went wrong; authentication is not provided.\n");
            throw new RuntimeException("Something went wrong; authentication is not provided.");
        }
        Collection<? extends GrantedAuthority> a = authentication.getAuthorities();
        if (!(authentication.getPrincipal() instanceof Jwt)) {
            throw new UnauthorizedException();
        }
        Jwt jwt = (Jwt) authentication.getPrincipal();
        if (StringUtils.isEmpty(jwt.getClaimAsString("resource_access"))) {
            throw new UnauthorizedException("You do not have any roles.");
        }
        Map<String, Map<String, List<String>>> map = objectMapper.readValue(jwt.getClaimAsString("resource_access"), Map.class);
        List<String> roles = map.get(clientId).get("roles");
        logger.info("You are [{}] with e-mail address [{}].\n roles: [{}]",
                jwt.getSubject(), jwt.getClaimAsString("email"), Arrays.toString(roles.stream().toArray()));
        if (!defaultService.checkPermission(className, methodName, roles)) {
            throw new UnauthorizedException("You lack necessary roles for this action.");
        }
        ;
    }

}
