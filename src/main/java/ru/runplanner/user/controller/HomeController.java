package ru.runplanner.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.runplanner.user.dto.UserCreateDto;
import ru.runplanner.user.model.User;
import ru.runplanner.user.service.impl.UserServiceImpl;
import ru.runplanner.user.storage.UserRepository;

import java.security.Principal;



@Controller
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository repository;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/register").setViewName("register");
//    }

    @ModelAttribute("user")
    public void commonUser(Principal principal, Model model) {
        if (principal != null) {
            String email = principal.getName();
            User user = repository.findByEmail(email);
            model.addAttribute("user", user);
        }
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserCreateDto());
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/user/profile")
    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        User user = repository.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("userDto") UserCreateDto userDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        userService.saveUser(userDto);

        return "redirect:/register";
    }

}
