package ru.runplanner.register;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.runplanner.register.dto.UserRegistrationRequest;
import ru.runplanner.register.service.RegistrationService;

@RestController
@RequestMapping("api/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
