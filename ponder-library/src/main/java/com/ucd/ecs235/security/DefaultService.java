package com.ucd.ecs235.security;

import com.ucd.ecs235.dto.PolicyStatement;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DefaultService {

    static Map<String, List<String>> functionToScopeMap = new HashMap<>();

    static {
        //read from text file
        PolicyStatement ps1 = new PolicyStatement();
        PolicyStatement ps2 = new PolicyStatement();
        PolicyStatement ps3 = new PolicyStatement();
        List<PolicyStatement> pss = Arrays.asList(ps1, ps2, ps3);


        pss.forEach(ps -> {
            List<String> list = functionToScopeMap.getOrDefault(ps.getTargetDomain(), new ArrayList<>());
            list.add(ps.getSubjectDomain());
            functionToScopeMap.put(ps.getTargetDomain(), list);
        });

    }

    public boolean checkPermission(String targetType, Object permission) {
        functionToScopeMap.get(targetType);

        return ;
    }
}
