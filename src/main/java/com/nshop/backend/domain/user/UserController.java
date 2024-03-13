package com.nshop.backend.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        UserEntity users = userService.create(userDto);
        return ResponseEntity.ok(new UserDto(users.getUsername()).getUsername());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable(name = "id") Long id) {
        UserEntity users = userService.readOne(id);
        return ResponseEntity.ok(new UserDto(users.getUsername()).getUsername());
    }

    @PostMapping("/account/login")
    public ResponseEntity login(@RequestBody Map<String, String> params) {

        UserDto userRequestDto = UserDto.builder()
                .username(params.get("username"))
                .password(params.get("password"))
                .build();

        UserDto userResponseDto = userService.login(userRequestDto);
        return ResponseEntity.ok(userResponseDto.getUsername());
    }
}
