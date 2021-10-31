package com.ucd.ecs235.client.controller.dto;

import com.ucd.ecs235.client.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CourseCommand {
    private String name;
    private Level level;
    private Long lecturerId;
}
