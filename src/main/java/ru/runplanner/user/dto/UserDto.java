package ru.runplanner.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    private String login;
    private String email;
    private String password;

}
