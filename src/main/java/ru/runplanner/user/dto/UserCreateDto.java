package ru.runplanner.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @NotBlank(message = "Поле должно быть заполнено")
    @Size(min = 3, max = 48, message = "Логин должен быть размером от 3 до 48 символов")
    private String login;

    @NotBlank(message = "Поле должно быть заполнено")
    @Email(message = "Email должен иметь символ @")
    private String email;

    @NotBlank(message = "Поле должно быть заполнено")
    @Size(min = 5, max = 48, message = "Пароль должен быть размером от 5 до 48 символов")
    private String password;
}
