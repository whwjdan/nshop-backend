package com.nshop.backend.domain.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String password;

    UserDto(String username) {
        this.username = username;
    }

    private UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserDto of(UserEntity userEntity) {
        return new UserDto(userEntity.getUsername());
    }

    public static UserDto from(UserEntity userEntity) {
        return new UserDto(userEntity.getUsername(),
                userEntity.getPassword());
    }
}