package com.example.holiday.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    Optional<List<ChatRoom>> findAllByUserId1(Long id);
    Optional<List<ChatRoom>> findAllByUserId2(Long id);
}
