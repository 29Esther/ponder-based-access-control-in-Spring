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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {

    private final CourseRegistrationRepo crRepo;
    private final CourseRepo courseRepo;
    private final UserRepo userRepo;

    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Course createCourse(CourseCommand courseCommand) {
        User lecturer = userRepo.findById(courseCommand.getLecturerId()).orElseThrow(() ->
                new ApiServiceException(HttpStatus.NOT_FOUND, "404-2", "cannot find lecturer"));
        Course course = Course.builder().name(courseCommand.getName()).level(courseCommand.getLevel())
                .lecturer(lecturer).build();
        return courseRepo.save(course);
    }

    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
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
    @PreAuthorize("hasAnyRole('ROLE_TA', 'ROLE_LEC')")
    public CourseRegistration updateGrade(Long studentId, Long courseId, GradeCommand gradeCommand) {
        CourseRegistration cr = crRepo.findByStudentIdAndCourseId(studentId, courseId);
        if (cr == null) {
            throw new ApiServiceException(HttpStatus.NOT_FOUND, "404-3", "the student has not registered the course");
        }
        cr.setGrade(gradeCommand.getGrade());
        return crRepo.save(cr);
    }

    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public void deleteCourseRegistration(Long id) {
        crRepo.deleteById(id);
    }
}
