package ru.runplanner.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String login;
    private String email;
    private String password;

}
