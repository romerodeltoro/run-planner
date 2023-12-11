package ru.runplanner.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.runplanner.user.model.User;
import ru.runplanner.user.storage.UserRepository;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        if (result.getId() > 0) {
            return ResponseEntity.ok("User was saved");
        }
        return ResponseEntity.status(404).body("Error, user not saved");
    }

    @GetMapping("user/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("user/single")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<Object> getMyDetails() {
        return ResponseEntity.ok(userRepository.findByEmail(getLoggedInUserDetails().getUsername()));
    }

    private UserDetails getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

}
