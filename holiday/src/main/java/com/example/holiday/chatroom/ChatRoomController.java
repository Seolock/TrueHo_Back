package com.example.holiday.chatroom;

import com.example.holiday.chat.dto.ChatRequest;
import com.example.holiday.chat.dto.ChatResponse;
import com.example.holiday.chatroom.dto.ChatRoomResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {


    private final ChatRoomService chatRoomService;


    Long checkSession(HttpSession session) {
        return null;
    }


    @PostMapping("/hansum/chat/{id}")
    public ResponseEntity<ChatResponse> createChatRoom(@PathVariable Long id, @RequestBody ChatRequest chatRequest, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ;

        return ResponseEntity.ok().body(chatRoomService.createChatRoom(id,chatRequest,userId));
    }


    @GetMapping("/chat/list")
    public ResponseEntity<List<ChatRoomResponse>> getChatRoomList(HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ;

        return ResponseEntity.ok().body(chatRoomService.getChatRoomList(userId));
    }


    @GetMapping("/chat/content/{id}")
    public ResponseEntity<List<ChatResponse>> getChatRoomContent(@PathVariable Long id, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ;

        return ResponseEntity.ok().body(chatRoomService.getChatRoomContent(id, userId));
    }


    @GetMapping("/chat/profile/{id}")
    public ResponseEntity<> getChatRoomProfile(@PathVariable Long id, HttpSession session){
        Long userId = checkSession(session);
        if(userId == null) return ;
        return ResponseEntity.ok().body(chatRoomService.getChatRoomProfile(id, userId));
    }


    @PostMapping("/chat/message/{id}")
    public ResponseEntity<ChatResponse> sendChatMessage(@PathVariable Long id, @RequestBody ChatRequest chatRequest, HttpSession session) {
        Long userId = checkSession(session);
        if(userId == null) return ;
        return ResponseEntity.ok().body(chatRoomService.sendChatMessage(id,chatRequest,userId));
    }








}
