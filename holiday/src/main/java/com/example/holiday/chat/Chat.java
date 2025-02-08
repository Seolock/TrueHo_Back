package com.example.holiday.chat;

import com.example.holiday.chatroom.ChatRoom;
import com.example.holiday.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderId;
    private String content;
    private Long read;

    @ManyToOne
    @JoinColumn(nullable=false)
    private ChatRoom chatRoom;


    public static Chat chat(Long id, String content, ChatRoom chatRoom) {
        return Chat.builder()
                .senderId(id)
                .content(content)
                .chatRoom(chatRoom)
                .read(0L)
                .build();
    }
}
