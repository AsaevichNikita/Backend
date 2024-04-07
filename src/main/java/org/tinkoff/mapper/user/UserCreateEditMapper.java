package org.tinkoff.mapper.user;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.User;
import org.tinkoff.dto.user.UserCreateEditDto;
import org.tinkoff.mapper.Mapper;


@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto userCreateEditDto) {
        User user = new User();
        copy(userCreateEditDto, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDto userCreateEditDto, User user) {
        copy(userCreateEditDto, user);
        return user;
    }

    public void copy(UserCreateEditDto userCreateEditDto, User user) {
        user.setFullName(userCreateEditDto.getFullName());
        user.setUserRoleDto(userCreateEditDto.getUserRoleDto());
        user.setBirthday(userCreateEditDto.getBirthday());
        user.setEmail(userCreateEditDto.getEmail());
    }
}
