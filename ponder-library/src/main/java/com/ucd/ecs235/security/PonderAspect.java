package com.ucd.ecs235.security;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Aspect
@Component
@AllArgsConstructor
public class PonderAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private DefaultService defaultService;

    @Pointcut("within(@EnablePonderCheck *)")
    public void PonderCheckClassMethods() {
    };

    @Before("PonderCheckClassMethods()")
    public void logPonderCheckClassMethods(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Before " + methodName);

        logger.debug("enter PonderMethodInterceptor");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            logger.error("Something went wrong; authentication is not provided.\n");
            throw new RuntimeException("Something went wrong; authentication is not provided.");
        }
        Collection<? extends GrantedAuthority> a = authentication.getAuthorities();
        if (authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            jwt.getClaims();
            logger.info("You are [{}] with e-mail address [{}].\n roles: [{}]",
                    jwt.getSubject(), jwt.getClaimAsString("email"), Arrays.toString(a.stream().toArray()));
        }
        defaultService.checkPermission(methodName, a);
//        throw new RuntimeException("wewew");
    }

}
