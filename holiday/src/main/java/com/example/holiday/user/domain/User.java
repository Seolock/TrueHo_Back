package com.example.holiday.user.domain;

import com.example.holiday.common.BaseEntity;
import com.example.holiday.common.StringListConverter;
import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleName;
    private String googleEmail;
    private String googleUserId;

    private Long showing;
    private Long hansum;
    private String name;
    private String admission;
    private String graduation;
    private String work;
    private String major;
    private String generation;
    private String imgUrl;

    @Convert(converter = StringListConverter.class)
    private List<Detail> history;


    public User(String userId, String email, String name){
        googleName = name;
        googleEmail = email;
        googleUserId = userId;
    }


    public void update(UserRequest userRequest) {

        this.showing = 1L;
        this.hansum = userRequest.getHansum();
        this.name = userRequest.getName();
        this.admission = userRequest.getAdmission();
        this.graduation = userRequest.getGraduation();
        this.major = userRequest.getMajor();
        this.work = userRequest.getWork();
        this.history = userRequest.getHistory();
    }


    public void setImageUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
