package com.example.holiday.user.dto;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder


public class UserDto {
    private Long id;

    private Long showing;
    private String name;
    private String studentId;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;
    private String major;


    public static UserDto from(User user) {
        return UserDto.builder()
                .showing(user.getShowing())
                .name(user.getName())
                .studentId(user.getStudentId())
                .work(user.getWork())
                .major(user.getMajor())
                .company(user.getCompany())
                .oneLine(user.getOneLine())
                .detail(user.getDetail())
                .academy(user.getAcademy())
                .licence(user.getLicence())
                .build();

    }

    public static UserDto from(UserRequest userRequest){
        return UserDto.builder()
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



}
