package dev.cafemanagement.server.auth;

import lombok.Data;

@Data
public class Login {
    private String username;
    private String password;
}
