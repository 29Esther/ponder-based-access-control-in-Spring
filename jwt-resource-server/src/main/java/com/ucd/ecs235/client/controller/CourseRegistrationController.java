package com.ucd.ecs235.client.controller;

import com.ucd.ecs235.client.controller.dto.CourseCommand;
import com.ucd.ecs235.client.controller.dto.CourseRegistrationCommand;
import com.ucd.ecs235.client.controller.dto.GradeCommand;
import com.ucd.ecs235.client.domain.Course;
import com.ucd.ecs235.client.domain.CourseRegistration;
import com.ucd.ecs235.client.service.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationsService;

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseCommand command) {
        return courseRegistrationsService.createCourse(command);
    }

    @PutMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@PathVariable Long id, @RequestBody CourseCommand command) {
        courseRegistrationsService.updateCourse(id, command);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseRegistrationsService.deleteCourse(id);
    }

    @PostMapping("/courseRegistrations")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseRegistration registerCourse(@RequestBody CourseRegistrationCommand command) {
        return courseRegistrationsService.createCourseRegistration(command);
    }

    @PutMapping("/courseRegistrations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGrade(@RequestParam Long studentId, @RequestParam Long courseId, @RequestBody GradeCommand command) {
        courseRegistrationsService.updateGrade(studentId, courseId, command);
    }

    @DeleteMapping("/courseRegistrations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unregisterCourse(@PathVariable Long id) {
        courseRegistrationsService.deleteCourseRegistration(id);
    }

}
