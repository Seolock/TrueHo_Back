package com.example.holiday.chat.dto;

import com.example.holiday.chat.Chat;
import lombok.Builder;


@Builder
public class ChatResponse {

    private Long flag;
    private String message;
    private String time;


    public static ChatResponse chatEtoR(Chat chat) {
        return ChatResponse.builder()
                .message(chat.getContent())
                .time(chat.getCreated().toString())
                .build();
    }

    public static ChatResponse chatEtoR(Chat chat, Long userId) {
        return ChatResponse.builder()
                .flag(chat.getSenderId().equals(userId)?1L:0L)
                .message(chat.getContent())
                .time(chat.getCreated().toString())
                .build();
    }


}
