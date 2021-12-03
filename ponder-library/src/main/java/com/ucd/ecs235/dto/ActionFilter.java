package com.ucd.ecs235.dto;

import java.util.Map;

public class ActionFilter {
    private String filterName;
    private String subjectType;
    private String subjectDomain;
    private String targetType;
    private String targetDomain;
    private String actionName;
    private String condition;
    private Map<String, String> defaultIn;
    private Map<String, String> in;
    private Map<String, String> out;
    private String result;

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public void setSubjectDomain(String subjectDomain) {
        this.subjectDomain = subjectDomain;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public void setTargetDomain(String targetDomain) {
        this.targetDomain = targetDomain;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDefaultIn(Map<String, String> defaultIn) {
        this.defaultIn = defaultIn;
    }

    public void setIn(Map<String, String> in) {
        this.in = in;
    }

    public void setOut(Map<String, String> out) {
        this.out = out;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFilterName() {
        return filterName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public String getSubjectDomain() {
        return subjectDomain;
    }

    public String getTargetType() {
        return targetType;
    }

    public String getTargetDomain() {
        return targetDomain;
    }

    public String getActionName() {
        return actionName;
    }

    public String getCondition() {
        return condition;
    }

    public Map<String, String> getDefaultIn() {
        return defaultIn;
    }

    public Map<String, String> getIn() {
        return in;
    }

    public Map<String, String> getOut() {
        return out;
    }

    public String getResult() {
        return result;
    }
}
