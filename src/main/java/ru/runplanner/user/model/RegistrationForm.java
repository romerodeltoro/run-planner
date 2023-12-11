package ru.runplanner.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.runplanner.user.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {


    @NotBlank(message = "Электронная почта не может быть пустой")
    @Email(message = "Электронная почта должна содержать символ @")
    private String email;
    @NotBlank
    @Size(min = 5, max = 50)
    private String password;

//    public UserDto toUserDto(PasswordEncoder passwordEncoder) {
//        return new UserDto(login, email, passwordEncoder.encode(password));
//    }

    public UserDto toUserDto() {
        return new UserDto(email, password);
    }
}
