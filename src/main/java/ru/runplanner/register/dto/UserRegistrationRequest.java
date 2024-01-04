package ru.runplanner.register.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UserRegistrationRequest {

    @NotBlank
    private final String login;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Min(value = 5, message = "Пароль должен иметь минимум 5 символов")
    private final String password;
}
