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

    private String name;
    private String studentId;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;


    public static User from(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .studentId(userRequest.getStudentId())
                .work(userRequest.getWork())
                .company(userRequest.getCompany())
                .oneLine(userRequest.getOneLine())
                .detail(userRequest.getDetail())
                .academy(userRequest.getAcademy())
                .licence(userRequest.getLicence())
                .build();


    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.studentId = userDto.getStudentId();
        this.work = userDto.getWork();
        this.company = userDto.getCompany();
        this.oneLine = userDto.getOneLine();
        this.detail = userDto.getDetail();
        this.academy = userDto.getAcademy();
        this.licence = userDto.getLicence();

    }





}
