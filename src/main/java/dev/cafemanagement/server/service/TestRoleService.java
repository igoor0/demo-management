package dev.cafemanagement.server.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class TestRoleService {

    @Secured("ROLE_ADMIN")
    public String performAdminTask() {
        return "Admin task";
    }

    @Secured("ROLE_MANAGER")
    public String performManagerTask() {
        return "MANAGER TASK";
    }

    @Secured("ROLE_USER")
    public String performUserTask() { return "USER TASK"; }
}