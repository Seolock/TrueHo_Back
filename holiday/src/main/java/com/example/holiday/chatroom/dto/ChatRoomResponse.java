package com.example.holiday.chatroom.dto;

import com.example.holiday.chatroom.ChatRoom;
import lombok.Builder;

@Builder
public class ChatRoomResponse {

    private Long id;
    private String name;
    private String imageUrl;
    private String lastChat;
    private Long flag;


    public static ChatRoomResponse chatRoomEtoR(ChatRoom chatRoom, Long userId){
        Long opposite=chatRoom.getUserId1().equals(userId)?chatRoom.getUserId2():chatRoom.getUserId1();
        return ChatRoomResponse.builder()
                .id(chatRoom.getId())
                .name()
                .imageUrl()
                .lastChat(chatRoom.getLastChat().getContent())
                .flag(chatRoom.getLastChat().getRead().equals(0L)?1L:0L)
                .build();
    }
}
