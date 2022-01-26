// package com.ESA.project.Admin;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.*;

// import lombok.RequiredArgsConstructor;

// @Controller
// @RequiredArgsConstructor
// @RequestMapping(value="/adminregister",method = RequestMethod.POST)
// public class AdminRegistrationController {

//     private final AdminUserRepository adminuserRepository;
//     private final PasswordEncoder passwordEncoder;

//     @GetMapping
//     public String registerForm() {
//         return "adminregistration";
//     }

//     @PostMapping
//     public String processRegistration(AdminRegistrationForm form) {
//         adminuserRepository.save(form.toUser(passwordEncoder));
//         return "redirect:/adminlogin";
//     }
// }
