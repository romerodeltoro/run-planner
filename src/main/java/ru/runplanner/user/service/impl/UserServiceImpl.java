package ru.runplanner.user.service.impl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.runplanner.user.dto.UserCreateDto;
import ru.runplanner.user.mapper.UserMapper;
import ru.runplanner.user.model.User;
import ru.runplanner.user.service.UserService;
import ru.runplanner.user.storage.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserCreateDto saveUser(UserCreateDto userDto) {

        String password = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(password);
        User createdUser = userRepository.save(UserMapper.INSTANCE.toUser(userDto));
        createdUser.setRole("ROLE_USER");
        log.info("Создан новый пользователь {}", createdUser);

        return UserMapper.INSTANCE.toUserDto(createdUser);
    }

    @Override
    public void removeSessionMessage() {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();

        session.removeAttribute("msg");
    }

}