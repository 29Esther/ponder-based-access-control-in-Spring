package com.ucd.ecs235.client.repo;

import com.ucd.ecs235.client.domain.User;
import com.ucd.ecs235.security.EnablePonderCheck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnablePonderCheck
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByUserName(@Param("userName") String name);
}