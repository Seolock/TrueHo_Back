package com.example.holiday.user.service;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.dto.UserDto;
import com.example.holiday.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto findUserById(Long id) {
        UserDto userDto = UserDto.from(userRepository.findById(id).orElse(null));
        return userDto;
    }


    @Transactional
    public UserDto updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElse(null);
        user.update(UserDto.from(userRequest));
        return UserDto.from(user);
    }
}
