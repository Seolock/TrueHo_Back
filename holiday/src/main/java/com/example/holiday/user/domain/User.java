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
        String[] generation={"근본","느혜미야의","상상하는","회복의","사랑의","은혜의","화평의","동행의","기쁨의","꿈꾸는","소망의","약속의","빛나는","함께하는","온유의","축복의","부르심의","세워가는"};
        this.showing = 1L;
        this.hansum = userRequest.getHansum();
        this.name = userRequest.getName();
        this.admission = userRequest.getAdmission();
        this.graduation = userRequest.getGraduation();
        this.major = userRequest.getMajor();
        this.work = userRequest.getWork();
        this.history = userRequest.getHistory();
        this.generation=generation[Integer.parseInt(admission)-2008]+"세대";
    }


    public void setImageUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
