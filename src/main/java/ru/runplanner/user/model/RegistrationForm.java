package ru.runplanner.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;
import ru.runplanner.user.dto.UserDto;

@Data
public class RegistrationForm {

    @NotBlank(message = "Поле login не может быть пустым")
    @Size(min = 3, max = 50)
    private String login;
//    @NotBlank(message = "Электронная почта не может быть пустой")
//    @Email(message = "Электронная почта должна содержать символ @")
    private String email;
//    @NotBlank
//    @Size(min = 5, max = 50)
    private String password;

//    public UserDto toUserDto(PasswordEncoder passwordEncoder) {
//        return new UserDto(login, email, passwordEncoder.encode(password));
//    }

    public UserDto toUserDto() {
        return new UserDto(login, email, password);
    }
}
