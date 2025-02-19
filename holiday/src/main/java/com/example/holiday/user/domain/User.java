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
        imgUrl="https://likelionpractice1.s3.ap-northeast-2.amazonaws.com/holiday/703c72b0-ca97-466b-867c-27652ac93a01_temp11675822538280352132hansum.png";
    }


    public void update(UserRequest userRequest) {
        String[] generation={"근본","느혜미야의","상상하는","회복의","사랑의","은혜의","화평의","동행의","기쁨의","꿈꾸는","소망의","약속의","빛나는","함께하는","온유의","축복의","부르심의","세워가는"};
        this.showing = userRequest.getShowing()==null?1L:userRequest.getShowing();
        this.hansum = userRequest.getHansum();
        this.name = userRequest.getName();
        this.admission = userRequest.getAdmission();
        this.graduation = userRequest.getGraduation();
        this.major = userRequest.getMajor();
        this.work = userRequest.getWork();
        List<Detail> list=userRequest.getHistory();
        if(list.get(0).getName().equals("0")) list.remove(0);
        this.history = list;
        this.generation=generation[Integer.parseInt(admission)-2008]+"세대";
    }


    public void setImageUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
