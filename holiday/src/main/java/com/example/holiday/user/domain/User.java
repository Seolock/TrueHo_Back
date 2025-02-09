package com.example.holiday.user.domain;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String googleName;
    private String googleEmail;
    private String googleUserId;

    private Long hansum;
    private Long showing;
    private String name;
    private String studentId;
    private String major;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;
    private String imgUrl;


    public User(String userId, String email, String name){
        googleName = name;
        googleEmail = email;
        googleUserId = userId;
    }


    public void update(UserRequest userRequest) {
        this.showing = 1L;
        this.hansum = userRequest.getHansum();
        this.name = userRequest.getName();
        this.studentId = userRequest.getStudentId();
        this.major = userRequest.getMajor();
        this.work = userRequest.getWork();
        this.company = userRequest.getCompany();
        this.oneLine = userRequest.getOneLine();
        this.detail = userRequest.getDetail();
        this.academy = userRequest.getAcademy();
        this.licence = userRequest.getLicence();

    }





}
