package com.nshop.backend.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(UserDto userDto) {

        UserEntity userEntity = UserEntity.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();

        return userRepository.save(userEntity);
    }

    public UserEntity readOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserDto login(UserDto userDto) {

        Optional<UserEntity> UserResult = userRepository.findByUsernameAndPassword(userDto.getUsername(),
                userDto.getPassword());

        UserDto userResponseDto = UserDto.of(UserResult
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        return userResponseDto;
    }
}