package com.ucd.ecs235.client.service;

import com.ucd.ecs235.client.controller.dto.CourseCommand;
import com.ucd.ecs235.client.controller.dto.CourseRegistrationCommand;
import com.ucd.ecs235.client.controller.dto.GradeCommand;
import com.ucd.ecs235.client.domain.Course;
import com.ucd.ecs235.client.domain.CourseRegistration;
import com.ucd.ecs235.client.domain.User;
import com.ucd.ecs235.client.exception.ApiServiceException;
import com.ucd.ecs235.client.repo.CourseRegistrationRepo;
import com.ucd.ecs235.client.repo.CourseRepo;
import com.ucd.ecs235.client.repo.UserRepo;
import com.ucd.ecs235.security.EnablePonderCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@EnablePonderCheck
public class CourseRegistrationService {

    private final CourseRegistrationRepo crRepo;
    private final CourseRepo courseRepo;
    private final UserRepo userRepo;

    @Transactional
    public Course createCourse(CourseCommand courseCommand) {
        User lecturer = userRepo.findById(courseCommand.getLecturerId()).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-2", "cannot find lecturer"));
        Course course = Course.builder().name(courseCommand.getName()).level(courseCommand.getLevel())
                .lecturer(lecturer).build();
        return courseRepo.save(course);
    }

    @Transactional
    public Course updateCourse(Long id, CourseCommand courseCommand) {
        Course course = courseRepo.findById(id).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-1", "cannot find course"));
        User lecturer = userRepo.findById(courseCommand.getLecturerId()).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-2", "cannot find lecturer"));

        BeanUtils.copyProperties(courseCommand, course);
        course.setLecturer(lecturer);
        return courseRepo.save(course);
    }

    @Transactional
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Transactional
    public CourseRegistration createCourseRegistration(CourseRegistrationCommand crCommand) {
        User student = userRepo.findById(crCommand.getStudentId()).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-2", "cannot find student with id"));
        Course course = courseRepo.findById(crCommand.getCourseId()).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-3", "cannot find course with id"));
        if (crRepo.findByStudentIdAndCourseId(crCommand.getStudentId(), crCommand.getCourseId()) != null) {
            throw new ApiServiceException(HttpStatus.CONFLICT, "409-1", "the student has registered the course");
        }
        CourseRegistration cr = CourseRegistration.builder().student(student).course(course).build();
        return crRepo.save(cr);
    }

    @Transactional
    public CourseRegistration updateGrade(Long studentId, Long courseId, GradeCommand gradeCommand) {
        CourseRegistration cr = crRepo.findByStudentIdAndCourseId(studentId, courseId);
        if (cr == null) {
            throw new ApiServiceException(HttpStatus.NOT_FOUND, "404-3", "the student has not registered the course");
        }
        cr.setGrade(gradeCommand.getGrade());
        return crRepo.save(cr);
    }

    @Transactional
    public void deleteCourseRegistration(Long id) {
        crRepo.deleteById(id);
    }
}
