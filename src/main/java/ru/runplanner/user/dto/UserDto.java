package ru.runplanner.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    @NotBlank(message = "Поле login не может быть пустым")
    private String login;
    @NotBlank(message = "Электронная почта не может быть пустой")
    @Email(message = "Электронная почта должна содержать символ @")
    private String email;
    private int age;
    private final LocalDateTime registration = LocalDateTime.now();
}
