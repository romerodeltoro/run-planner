package ru.runplanner.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.runplanner.user.model.UserDto;
import ru.runplanner.user.service.UserService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> creatUser(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }



}
