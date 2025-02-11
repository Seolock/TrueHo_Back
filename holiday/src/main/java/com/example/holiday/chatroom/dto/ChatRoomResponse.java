package com.example.holiday.chatroom.dto;

import com.example.holiday.chatroom.ChatRoom;
import com.example.holiday.user.domain.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomResponse {

    private Long id;
    private String name;
    private String imgUrl;
    private String lastChat;
    private Long unreadMessage;


    public static ChatRoomResponse chatRoomEtoR(ChatRoom chatRoom, User user){
        return ChatRoomResponse.builder()
                .id(chatRoom.getId())
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .lastChat(chatRoom.getLastChat().getContent())
                .unreadMessage(chatRoom.getLastChat().getReadState()?0L:1L)
                .build();
    }
}
