package ru.runplanner.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.runplanner.user.model.RegistrationForm;
import ru.runplanner.user.service.UserService;

@Slf4j
@Validated
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid @RequestBody RegistrationForm form) {
        userService.createUser(form.toUserDto(passwordEncoder));
        return "redirect:/login";
    }
}
