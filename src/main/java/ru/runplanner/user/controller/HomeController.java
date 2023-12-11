package ru.runplanner.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.runplanner.user.model.RegistrationForm;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


}
