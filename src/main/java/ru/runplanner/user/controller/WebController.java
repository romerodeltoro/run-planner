package ru.runplanner.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class WebController {

    @GetMapping
    public String getHome() {
        return "Hello!";
    }

    @GetMapping("/user/{id}/dashboard")
    public String getDashboard(@PathVariable Long id) {
        return "dashboard";
    }
}
