package com.example.holiday.chatroom;

import com.example.holiday.chat.Chat;
import com.example.holiday.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom extends BaseEntity implements Comparable<ChatRoom>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId1;
    private Long userId2;

    @OneToMany(mappedBy="chatRoom", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Chat> chats=new ArrayList<>();


    public static ChatRoom chatRoom(Long userId1, Long userId2) {
        return ChatRoom.builder()
                .userId1(userId1)
                .userId2(userId2)
                .build();
    }

    public Chat getLastChat(){
        return chats.get(chats.size()-1);
    }

    public void readChatRoom(Long id){
        if(!userId1.equals(id) && !userId2.equals(id)) return;
        for(Chat chat : chats){
            if(!chat.getSenderId().equals(id)){
                chat.setReadState(true);
            }
        }
    }

    @Override
    public int compareTo(ChatRoom chatRoom){
        if(this.getLastChat().getCreated().isAfter(chatRoom.getLastChat().getCreated())){
            return -1;
        }
        else if(this.getLastChat().getCreated().isBefore(chatRoom.getLastChat().getCreated())){
            return 1;
        }
        else return 0;
    }
}
