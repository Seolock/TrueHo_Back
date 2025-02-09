package com.example.holiday.user.service;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.dto.UserDto;
import com.example.holiday.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


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
        user.update(userRequest);
        return UserDto.from(user);
    }



    public List<UserDto> findAllHausums() {
        List<UserDto> userDtoList = userRepository.findAllByHansum(1L).stream().map(UserDto::from).toList();
        return userDtoList;
    }


    public Long checkExist(String userId, String email, String name) {
        User user=userRepository.findByGoogleUserId(userId).orElse(null);
        if(user==null) return null;
        return user.getId();
    }

    public Long addUser(String userId, String email, String name) {
        User user=userRepository.findByGoogleUserId(userId).orElse(null);
        if(user==null){
            User newUser=new User(userId,email,name);
            userRepository.save(newUser);
            return null;
        }
        return user.getId();
    }
}
