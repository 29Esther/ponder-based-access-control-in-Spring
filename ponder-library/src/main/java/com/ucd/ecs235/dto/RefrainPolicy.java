package com.ucd.ecs235.dto;

public class RefrainPolicy {
    private String policyName;
    private String subjectType;
    private String subjectDomain;
    private String targetType;
    private String targetDomain;
    private String action;

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setAction(String action) {
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

    public String getAction() {
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
