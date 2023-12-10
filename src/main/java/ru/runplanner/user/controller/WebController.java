package ru.runplanner.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class WebController {






    @GetMapping("/user/{id}/dashboard")
    public String getDashboard(@PathVariable Long id) {
        return "dashboard";
    }
}
