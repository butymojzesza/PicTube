package com.prz.Converter;

import com.prz.DataBase.User;
import com.prz.Dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User convertToEntity(UserDto userDto) {

        return User.builder()
                ._id(userDto.get_id())
                .likeHasztags(Arrays.asList(StringToList.convertToArray(userDto.getLikeHasztagsNoHasz().get(0))))
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .ifAdmin(userDto.isIfAdmin())
                .build();
    }

    @Override
    public UserDto convertToDto(User user) {
        return UserDto.builder()
                ._id(user.get_id())
                .likeHasztags(user.getLikeHasztags())
                .login(user.getLogin())
                .name(user.getName())
                .password(user.getPassword())
                .ifAdmin(user.isIfAdmin())
                .build();
    }
}
