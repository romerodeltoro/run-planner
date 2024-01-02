package ru.runplanner.register.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UserRegistrationRequest {

    private final String login;
    private final String email;
    private final String password;
}
