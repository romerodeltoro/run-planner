package ru.runplanner.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.runplanner.user.dto.UserDto;

@Data
public class RegistrationForm {

    @NotBlank(message = "Поле login не может быть пустым")
    private String login;
    @NotBlank(message = "Электронная почта не может быть пустой")
    @Email(message = "Электронная почта должна содержать символ @")
    private String email;
    @NotBlank
    private String password;

    public UserDto toUserDto(PasswordEncoder passwordEncoder) {
        return new UserDto(login, email, passwordEncoder.encode(password));
    }
}
