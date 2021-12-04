package com.ucd.ecs235.security;

import com.ucd.ecs235.compiler.Ponder;
import com.ucd.ecs235.dto.ActionFilter;
import com.ucd.ecs235.dto.AuthPolicy;
import com.ucd.ecs235.dto.RefrainPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultService {

    Map<String, List<String>> functionToScopeMap = new HashMap<>();

    @Value("${ponder.config.file.name}")
    String fileName;

    public final static String ALL = "*";

    boolean loaded = false;

    private void reloadTheMap() {
        //read from text file
        try {
            Ponder.compile(fileName);
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            System.out.println("Ponder Compiler error: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateAccessControlMap();
    }

    public void generateAccessControlMap() {
        functionToScopeMap.clear();
        List<AuthPolicy> authPolicies = Ponder.getAuthPolicies();
        List<ActionFilter> actionFilters = Ponder.getActionFilters();
        List<RefrainPolicy> refrainPolicies = Ponder.getRefrainPolicies();
        authPolicies.forEach(authPolicy -> {
            List<String> actionList = authPolicy.getAction();
            String subjectType = authPolicy.getSubjectType();
            subjectType = subjectType.replace("<", "").replace(">", "");
            String subjectDomain = authPolicy.getSubjectDomain();
            String[] subjectDomainSeq = subjectDomain.split("/");
            subjectDomain = subjectDomainSeq[subjectDomainSeq.length - 1];
            String targetType = authPolicy.getTargetType();
            targetType = targetType.replace("<", "").replace(">", "");
            String targetDomain = authPolicy.getTargetDomain();
            String[] targetDomainSeq = targetDomain.split("/");
            targetDomain = targetDomainSeq[targetDomainSeq.length - 1];

            if (targetType.equals("Class")) {
                for (String action : actionList) {
                    action = action.replace("(", "").replace(")", "");
                    String key = targetDomain + "#_#" + action;
                    if (subjectType.equals("Authentication")) {
                        if (authPolicy.isAuthPlus()) {
                            if (functionToScopeMap.containsKey(key)) {
                                functionToScopeMap.get(key).add(subjectDomain);
                            } else {
                                ArrayList<String> subjects = new ArrayList<>();
                                subjects.add(subjectDomain);
                                functionToScopeMap.put(key, subjects);
                            }
                        } else {
                            if (functionToScopeMap.containsKey(key)) {
                                if (functionToScopeMap.get(key).contains(subjectDomain)) {
                                    functionToScopeMap.get(key).remove(subjectDomain);
                                }
                            }
                        }
                    }
                }
            }
        });
        refrainPolicies.forEach(refrainPolicy -> {
            String action = refrainPolicy.getAction();
            action = action.replace("(", "").replace(")", "");
            String subjectType = refrainPolicy.getSubjectType();
            subjectType = subjectType.replace("<", "").replace(">", "");
            String subjectDomain = refrainPolicy.getSubjectDomain();
            String[] subjectDomainSeq = subjectDomain.split("/");
            subjectDomain = subjectDomainSeq[subjectDomainSeq.length - 1];
            String targetType = refrainPolicy.getTargetType();
            targetType = targetType.replace("<", "").replace(">", "");
            String targetDomain = refrainPolicy.getTargetDomain();
            String[] targetDomainSeq = targetDomain.split("/");
            targetDomain = targetDomainSeq[targetDomainSeq.length - 1];

            if (targetType.equals("Class")) {
                String key = targetDomain + "#_#" + action;
                if (subjectType.equals("Authentication")) {
                    if (functionToScopeMap.containsKey(key)) {
                        if (functionToScopeMap.get(key).contains(subjectDomain)) {
                            functionToScopeMap.get(key).remove(subjectDomain);
                        }
                    }
                }
            }
        });
    }

    public void clearTheMap() {
        loaded = false;
        functionToScopeMap.clear();
    }

    public boolean checkPermission(String className, String targetAction, List<String> roles) {
        if (!loaded) {
            reloadTheMap();
            loaded = true;
        }

        String key = className;
        if (functionToScopeMap.containsKey(key) && ALL.equals(functionToScopeMap.get(key))) {
            return false;
        }

        key += "#_#" + targetAction;
        if (!functionToScopeMap.containsKey(key)) {
            return false;
        }

        List<String> list = functionToScopeMap.get(key);
        return roles.stream().anyMatch(s -> list.contains(s));
    }
}
