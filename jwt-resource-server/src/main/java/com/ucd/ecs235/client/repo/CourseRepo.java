package com.ucd.ecs235.client.repo;

import com.ucd.ecs235.client.domain.Course;
import com.ucd.ecs235.security.EnablePonderCheck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnablePonderCheck
public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {
    Optional<Course> findByName(@Param("name") String name);
}