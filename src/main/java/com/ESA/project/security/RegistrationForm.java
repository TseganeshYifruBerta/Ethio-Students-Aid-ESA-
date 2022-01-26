package com.ESA.project.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        return user;
    }
}
