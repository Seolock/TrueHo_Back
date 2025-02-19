package com.example.holiday.chatroom;

import com.example.holiday.chat.Chat;
import com.example.holiday.chat.ChatRepository;
import com.example.holiday.chat.dto.ChatRequest;
import com.example.holiday.chat.dto.ChatResponse;
import com.example.holiday.chatroom.dto.ChatRoomResponse;
import com.example.holiday.user.controller.response.UserProfileResponse;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {


    private final ChatRoomRepository chatRoomRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;


    public ChatResponse createChatRoom(Long id, ChatRequest chatRequest, Long userId) {
        ChatRoom chatRoom=chatRoomRepository.findByUserId1AndUserId2(id,userId).orElse(null);
        if(chatRoom==null) chatRoom=chatRoomRepository.findByUserId1AndUserId2(userId,id).orElse(null);
        if(chatRoom!=null){
            sendChatMessage(chatRoom.getId(),chatRequest,userId);
            return ChatResponse.chatEtoR(chatRoom.getId(),chatRoom.getLastChat());
        }
        chatRoom = ChatRoom.chatRoom(id,userId);
        Chat chat=Chat.chat(userId, chatRequest.getMessage(), chatRoomRepository.save(chatRoom));
        chatRepository.save(chat);
        chatRoom=chatRoomRepository.findByUserId1AndUserId2(id,userId).orElse(null);
        return ChatResponse.chatEtoR(chatRoom.getId(),chat);
    }


    public List<ChatRoomResponse> getChatRoomList(Long userId) {
        List<ChatRoom> list1=chatRoomRepository.findAllByUserId1(userId).orElse(null);
        List<ChatRoom> list2=chatRoomRepository.findAllByUserId2(userId).orElse(null);
        List<ChatRoom> list=new ArrayList<>();
        if(list1!=null) list.addAll(list1);
        if(list2!=null) list.addAll(list2);
        Collections.sort(list);
        //list.sort(Comparator.comparing(chatRoom->chatRoom.getLastChat().getCreated()));
        return list.stream().map(chatRoom -> ChatRoomResponse.chatRoomEtoR(chatRoom,getOtherUser(chatRoom,userId))).toList();
    }


    User getOtherUser(ChatRoom chatRoom, Long userId) {
        User user;
        if(chatRoom.getUserId1().equals(userId)) user=userRepository.findById(chatRoom.getUserId2()).orElse(null);
        else user=userRepository.findById(chatRoom.getUserId1()).orElse(null);
        return user;
    }


    @Transactional
    public List<ChatResponse> getChatRoomContent(Long id, Long userId) {
        ChatRoom chatRoom=chatRoomRepository.findById(id).orElse(null);
        if(chatRoom==null) return null;
        chatRoom.readChatRoom(userId);
        List<Chat> chats=chatRoom.getChats();
        return chats.stream().map(chat->ChatResponse.chatEtoR(chat,userId)).toList();
    }


    public ChatResponse sendChatMessage(Long id, ChatRequest chatRequest, Long userId) {
        ChatRoom chatRoom=chatRoomRepository.findById(id).orElse(null);
        if(chatRoom==null) return null;
        Chat chat=chatRepository.save(Chat.chat(userId, chatRequest.getMessage(), chatRoom));
        return ChatResponse.chatEtoR(chat);
    }


    public UserProfileResponse getChatRoomProfile(Long id, Long userId) {
        ChatRoom chatRoom=chatRoomRepository.findById(id).orElse(null);
        if(chatRoom==null) return null;
        User user=userRepository.findById(chatRoom.getUserId1().equals(userId)?chatRoom.getUserId2():chatRoom.getUserId1()).orElse(null);
        if(user==null) return null;
        return UserProfileResponse.profileEtoR(user);
    }

}
