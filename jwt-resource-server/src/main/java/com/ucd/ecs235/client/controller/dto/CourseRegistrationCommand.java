package com.ucd.ecs235.client.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationCommand {
    private Long studentId;
    private Long courseId;
}
