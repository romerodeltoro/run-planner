package ru.runplanner.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.runplanner.user.model.RegistrationForm;
import ru.runplanner.user.service.impl.UserServiceImpl;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Validated
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController implements WebMvcConfigurer {

    private final UserServiceImpl userService;

    private final UserRepository repository;
//    private PasswordEncoder passwordEncoder;


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("form", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/createUser")
    public String submitForm(@Valid @ModelAttribute("form") RegistrationForm form, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }
            userService.createUser(form.toUserDto());
            model.addAttribute("users", repository.findAll());
            return "succeed";


    }
}
