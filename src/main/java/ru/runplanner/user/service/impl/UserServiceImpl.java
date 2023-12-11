package ru.runplanner.user.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.exceptions.AlreadyInitializedException;
import ru.runplanner.user.dto.UserDto;
import ru.runplanner.user.mapper.UserMapper;
import ru.runplanner.user.model.User;
import ru.runplanner.user.service.UserService;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.findByEmail(UserMapper.INSTANCE.toUser(userDto).getEmail()) != null) {
            throw new AlreadyInitializedException(String.format(
                    "Пользователь с электронной почтой %s уже зарегистрирован.", userDto.getEmail()
            ));
        }
        User user = userRepository.save(UserMapper.INSTANCE.toUser(userDto));
        log.info("Создан новый пользователь: '{}'", user);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    public String addUser(UserDto userDto) {
        if (userRepository.findByEmail(UserMapper.INSTANCE.toUser(userDto).getEmail()) != null) {
            throw new AlreadyInitializedException(String.format(
                    "Пользователь с электронной почтой %s уже зарегистрирован.", userDto.getEmail()
            ));
        } else {
            return null;
        }
    }

    @Override
    public UserDto getUser(Long id) {
        UserDto userDto = UserMapper.INSTANCE.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Пользователя с id=%d нет в базе", id)
                )));
        log.info("Получен пользователь {}", userDto);
        return userDto;
    }
}
