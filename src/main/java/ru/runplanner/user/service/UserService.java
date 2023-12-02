package ru.runplanner.user.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.runplanner.user.dto.UserDto;
import ru.runplanner.user.mapper.UserMapper;
import ru.runplanner.user.model.User;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(UserMapper.INSTANCE.toUser(userDto));
        log.info("Создан новый пользователь: '{}'", user);
        return UserMapper.INSTANCE.toUserDto(user);
    }
}
