package com.ucd.ecs235.security;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Import(DefaultService.class)
@Inherited
public @interface EnablePonderCheck {
}