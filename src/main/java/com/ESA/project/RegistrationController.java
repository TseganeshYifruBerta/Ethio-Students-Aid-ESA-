package com.ESA.project;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(Model model)
    {   User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form,
                                      @Valid @ModelAttribute("user") User user,
                                      Errors errors, Model model) {
        if(errors.hasErrors()){
            return "registration";
        }
        if (userRepository.findByUsername(user.getUsername()) != null){
            String message = "Email already exists.";
            model.addAttribute("message", message);
            return "registration";
        }
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
