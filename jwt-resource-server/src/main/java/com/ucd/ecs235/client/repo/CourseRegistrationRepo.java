package com.ucd.ecs235.client.repo;

import com.ucd.ecs235.client.domain.CourseRegistration;
import com.ucd.ecs235.security.EnablePonderCheck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

//@EnablePonderCheck
public interface CourseRegistrationRepo extends PagingAndSortingRepository<CourseRegistration, Long> {
    @Query(value="SELECT * from course_registration where course_id = ?2 and student_id = ?1", nativeQuery = true)
    CourseRegistration findByStudentIdAndCourseId(Long studentId, Long courseId);
}
