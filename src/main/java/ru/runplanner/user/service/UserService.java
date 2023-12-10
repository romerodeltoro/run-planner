/*
package ru.runplanner.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.exceptions.AlreadyInitializedException;
import ru.runplanner.mapper.UserMapper;
import ru.runplanner.user.model.User;
import ru.runplanner.user.model.UserDto;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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

    public UserDto getUser(Long id) {
        UserDto userDto = UserMapper.INSTANCE.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Пользователя с id=%d нет в базе", id)
                )));
        log.info("Получен пользователь {}", userDto);
        return userDto;
    }
}
*/
