package com.example.holiday.user.controller;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.controller.response.HansumResponse;
import com.example.holiday.user.controller.response.MyPageResponse;
import com.example.holiday.user.controller.response.UserResponse;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.dto.UserDto;
import com.example.holiday.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    Long checkSession(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        String name = (String) session.getAttribute("name");
        return userService.checkExist(userId, email, name);
    }

    @PutMapping("/main/register")
    public ResponseEntity<Object> userRegister(@RequestBody UserRequest userRequest, HttpSession session) {
        Long userId = checkSession(session);
        if (userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        UserDto userDto = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok().body(UserResponse.from(userDto));
    }

    @GetMapping("/user/detail")
    public ResponseEntity<Object> getUserById(HttpSession session) {
        Long userId = checkSession(session);
        if (userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        UserDto userDto = userService.findUserById(userId);
        return ResponseEntity.ok().body(MyPageResponse.from(userDto));
    }


    @GetMapping("/user/edit")
    public ResponseEntity<Object> getUser(HttpSession session) {
        Long userId = checkSession(session);
        if (userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        UserDto userDto = userService.findUserById(userId);
        return ResponseEntity.ok().body(UserResponse.from(userDto));
    }


    @PutMapping("/user/edit")
    public ResponseEntity<Object> updateUser(HttpSession session, @RequestBody UserRequest userRequest) {
        Long userId = checkSession(session);
        if (userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        UserDto userDto = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok().body(UserResponse.from(userDto));
    }


    @GetMapping("/hansum/list/{id}")
    public ResponseEntity<Object> getAllHansumList(HttpSession session, @PathVariable Long id) {
        if(checkSession(session)==null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        List<HansumResponse> hansumResponse = userService.findAllHausums(id).stream().map(HansumResponse::from).toList();
        return ResponseEntity.ok().body(hansumResponse);
    }


    @GetMapping("hansum/profile/{id}")
    public ResponseEntity<Object> getHansumProfile(HttpSession session, @PathVariable Long id) {
        if(checkSession(session)==null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        UserDto userDto = userService.findUserById(id);
        return ResponseEntity.ok().body(UserResponse.from(userDto));
    }


}
