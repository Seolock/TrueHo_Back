package com.example.holiday.user.repository;

import com.example.holiday.user.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByFromUserAndToUser(Long from, Long to);

}
