package ru.runplanner.user.service;

import ru.runplanner.user.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(Long id);
}
