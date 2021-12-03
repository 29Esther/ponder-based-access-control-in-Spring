package com.ucd.ecs235.dto;

import java.util.List;

public class AuthPolicy {
    private String policyName;
    private boolean authPlus;
    private String subjectType;
    private String subjectDomain;
    private String targetType;
    private String targetDomain;
    private List<String> action;

    public void setAuthPlus(boolean authPlus) {
        this.authPlus = authPlus;
    }

    public boolean isAuthPlus() {
        return authPlus;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setAction(List<String> action) {
        this.action = action;
    }

    public void setSubjectDomain(String subjectDomain) {
        this.subjectDomain = subjectDomain;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public void setTargetDomain(String targetDomain) {
        this.targetDomain = targetDomain;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public List<String> getAction() {
        return action;
    }

    public String getSubjectDomain() {
        return subjectDomain;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public String getTargetDomain() {
        return targetDomain;
    }

    public String getTargetType() {
        return targetType;
    }
}
