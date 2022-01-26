// package com.ESA.project.Admin;

// import org.springframework.security.crypto.password.PasswordEncoder;

// import lombok.Data;

// @Data
// public class AdminRegistration {
//     private String username;
//     private String password;
//     private String fullName;
//     private String phone;

//     AdminUsers toUser(PasswordEncoder encoder) {
//         AdminUsers user = new AdminUsers();
//         user.setUsername(this.username);
//         user.setPassword(encoder.encode(this.password));
//         user.setFullName(this.fullName);
//         user.setPhone(this.phone);
//         return user;
//     }
// }
