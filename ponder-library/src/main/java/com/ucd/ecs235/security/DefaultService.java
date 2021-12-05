package com.ucd.ecs235.security;

import com.ucd.ecs235.compiler.Ponder;
import com.ucd.ecs235.dto.ActionFilter;
import com.ucd.ecs235.dto.AuthPolicy;
import com.ucd.ecs235.dto.RefrainPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultService {

    Map<String, List<String>> functionToScopeMap = new HashMap<>();
    Map<String, List<String>> reftainFunctionToScopeMap = new HashMap<>();

    @Value("${ponder.config.file.name}")
    String fileName;
    String outputFileName = "./output.txt";

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
        outputMap();
    }

    public void generateAccessControlMap() {
        functionToScopeMap.clear();
        reftainFunctionToScopeMap.clear();
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
                    if (reftainFunctionToScopeMap.containsKey(key)) {
                        reftainFunctionToScopeMap.get(key).add(subjectDomain);
                    } else {
                        ArrayList<String> subjects = new ArrayList<>();
                        subjects.add(subjectDomain);
                        reftainFunctionToScopeMap.put(key, subjects);
                    }
                }
            }
        });
    }

    public void outputMap(){
        try {
            OutputStream fop = new FileOutputStream(outputFileName, true);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            writer.append("Authorization Map: \n");
            for(String key:functionToScopeMap.keySet()){
                writer.append("{"+key+": ");
                List<String> list = functionToScopeMap.get(key);
                writer.append("[");
                for (String scope: list) {
                    if(list.indexOf(scope)==list.size()-1){
                        writer.append(scope);
                    }else {
                        writer.append(scope + ",");
                    }
                }
                writer.append("]}\n");
            }
            writer.append("Refrain Map: \n");
            for(String key:reftainFunctionToScopeMap.keySet()){
                writer.append("{"+key+": ");
                List<String> list = reftainFunctionToScopeMap.get(key);
                writer.append("[");
                for (String scope: list) {
                    if(list.indexOf(scope)==list.size()-1){
                        writer.append(scope);
                    }else {
                        writer.append(scope + ",");
                    }
                }
                writer.append("]}\n");
            }
            writer.close();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        List<String> refrainList = reftainFunctionToScopeMap.get(key);
        if(roles.stream().anyMatch(s -> refrainList.contains(s))){
            return false;
        }

        if (!functionToScopeMap.containsKey(key)) {
            return false;
        }

        List<String> authList = functionToScopeMap.get(key);
        return roles.stream().anyMatch(s -> authList.contains(s));
    }
}
