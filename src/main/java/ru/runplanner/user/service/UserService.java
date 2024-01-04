package ru.runplanner.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.runplanner.register.token.ConfirmationToken;
import ru.runplanner.register.token.ConfirmationTokenService;
import ru.runplanner.user.model.User;
import ru.runplanner.user.storage.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService tokenService;



    public String addUser(User user) {
        findUserByEmailOrThrow(user.getEmail());

        String encodedPassword = passwordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        tokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }

    private User findUserByEmailOrThrow(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Пользователя с email - '%s' нет", email)));
    }
}
