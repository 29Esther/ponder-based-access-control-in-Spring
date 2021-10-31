package com.ucd.ecs235.security;

import org.springframework.stereotype.Service;

@Service
public class DefaultService {
    public boolean checkPermission(String targetType, Object permission) {
        return true;
    }
}
