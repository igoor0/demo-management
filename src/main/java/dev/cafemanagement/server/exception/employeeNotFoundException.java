package dev.cafemanagement.server.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class employeeNotFoundException extends UsernameNotFoundException {
    public employeeNotFoundException(String message) {
        super(message);
    }
}
