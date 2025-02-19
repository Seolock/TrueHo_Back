package com.example.holiday.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<List<ChatRoom>> findAllByUserId1(Long id);
    Optional<List<ChatRoom>> findAllByUserId2(Long id);

    boolean existsByUserId1AndUserId2(Long id1, Long id2);

    Optional<ChatRoom> findByUserId1AndUserId2(Long id, Long userId);
}
