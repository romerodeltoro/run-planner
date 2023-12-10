package ru.runplanner.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.runplanner.user.model.User;
import ru.runplanner.user.storage.UserRepository;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("user") User user, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }
        user.setRoles("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        model.addAttribute("users", repository.findAll());
        return "Успешная регистрация";
    }
}
