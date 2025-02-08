package com.example.holiday.user.controller;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.controller.response.UserResponse;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.dto.UserDto;
import com.example.holiday.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/detail")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.findUserById(id);
        return ResponseEntity.ok().body(UserResponse.from(userDto));

    }

    @PutMapping("/user/detail")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,@RequestBody UserRequest userRequest) {
        UserDto userDto = userService.updateUser(id ,userRequest);
        return ResponseEntity.ok().body(UserResponse.from(userDto));
    }







}
