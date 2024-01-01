package ru.runplanner.user.service;

import ru.runplanner.user.dto.UserCreateDto;
import ru.runplanner.user.model.User;

public interface UserService{

    UserCreateDto saveUser(UserCreateDto userDto);

    void removeSessionMessage();
}
