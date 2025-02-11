package com.example.holiday.chatroom;

import com.example.holiday.chat.dto.ChatRequest;
import com.example.holiday.chat.dto.ChatResponse;
import com.example.holiday.chatroom.dto.ChatRoomResponse;
import com.example.holiday.login.LoginResponse;
import com.example.holiday.user.controller.response.UserProfileResponse;
import com.example.holiday.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {


    private final ChatRoomService chatRoomService;
    private final UserService userService;

    Long checkSession(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        String name = (String) session.getAttribute("name");
        return userService.checkExist(userId, email, name);
    }


    @PostMapping("/hansum/chat/{id}")
    public ResponseEntity<Object> createChatRoom(@PathVariable Long id, @RequestBody ChatRequest chatRequest, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        return ResponseEntity.ok().body(chatRoomService.createChatRoom(id,chatRequest,userId));
    }


    @GetMapping("/chat/list")
    public ResponseEntity<Object> getChatRoomList(HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        return ResponseEntity.ok().body(chatRoomService.getChatRoomList(userId));
    }


    @GetMapping("/chat/content/{id}")
    public ResponseEntity<Object> getChatRoomContent(@PathVariable Long id, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        return ResponseEntity.ok().body(chatRoomService.getChatRoomContent(id, userId));
    }


    @GetMapping("/chat/profile/{id}")
    public ResponseEntity<Object> getChatRoomProfile(@PathVariable Long id, HttpSession session){
        Long userId = checkSession(session);
        if(userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        return ResponseEntity.ok().body(chatRoomService.getChatRoomProfile(id, userId));
    }


    @PostMapping("/chat/message/{id}")
    public ResponseEntity<Object> sendChatMessage(@PathVariable Long id, @RequestBody ChatRequest chatRequest, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ResponseEntity.ok().body(new LoginResponse("No login info"));
        return ResponseEntity.ok().body(chatRoomService.sendChatMessage(id,chatRequest,userId));
    }

}
