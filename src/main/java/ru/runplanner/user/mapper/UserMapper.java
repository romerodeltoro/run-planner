package ru.runplanner.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.runplanner.user.dto.UserCreateDto;
import ru.runplanner.user.model.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE  = Mappers.getMapper(UserMapper.class);

    UserCreateDto toUserDto(User user);

    User toUser(UserCreateDto userDto);
}
