package ru.runplanner.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.runplanner.user.model.User;
import ru.runplanner.user.model.UserDto;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
