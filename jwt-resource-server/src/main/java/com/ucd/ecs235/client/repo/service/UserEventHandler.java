package com.ucd.ecs235.client.repo.service;

import com.ucd.ecs235.client.domain.User;
import com.ucd.ecs235.security.EnablePonderCheck;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
@Slf4j
@EnablePonderCheck
public class UserEventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(UserEventHandler.class);

//    @PreAuthorize("hasAnyAuthority('SCOPE_WRITE')")
    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    public void modify(User user) {
        // check scopes
    }

//    @PreAuthorize("hasAnyAuthority('SCOPE_WRITE')")
//    @HandleBeforeSave
//    public void handleUserBeforeSave(User user) {
//        // check scopes
//    }

//    @PreAuthorize("hasAnyAuthority('SCOPE_DELETE')")
//    @HandleBeforeDelete
//    public void handleUserBeforeDelete(User user) {
//        // check scopes
//    }

}
