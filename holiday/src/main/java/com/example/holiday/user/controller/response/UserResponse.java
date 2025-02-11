package com.example.holiday.user.controller.response;

import com.example.holiday.user.domain.Detail;
import com.example.holiday.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;


@Getter
@Setter
@Builder
public class UserResponse {
    private String hansum;
    private String name;
    private String admission;
    private String graduation;
    private String work;
    private String major;
    private List<Detail> history;
    private String generation;
    private String imgUrl;

    public static UserResponse from(UserDto userDto) {
        return UserResponse.builder()
                .name(userDto.getName())
                .studentId(userDto.getStudentId())
                .work(userDto.getWork())
                .company(userDto.getCompany())
                .oneLine(userDto.getOneLine())
                .detail(userDto.getDetail())
                .academy(userDto.getAcademy())
                .licence(userDto.getLicence())
                .major(userDto.getMajor())
                .imgUrl(userDto.getImgUrl())
                .build();

    }
}
