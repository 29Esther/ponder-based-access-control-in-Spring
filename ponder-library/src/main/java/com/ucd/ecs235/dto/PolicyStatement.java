package com.ucd.ecs235.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PolicyStatement {
    private String policyName;
    private String subjectDomain;
    private String targetDomain;
    private List<String> actions;
}
