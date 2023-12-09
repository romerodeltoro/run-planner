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
import ru.runplanner.user.model.User;
import ru.runplanner.user.model.UserDto;
import ru.runplanner.user.service.UserService;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Validated
@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController implements WebMvcConfigurer {

    private final UserService userService;
    private final UserRepository repository;
//    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("form", new UserDto());
        return "registration";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("form") UserDto user, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }
        userService.createUser(user);
        model.addAttribute("users", repository.findAll());
        return "succeed";


    }
}