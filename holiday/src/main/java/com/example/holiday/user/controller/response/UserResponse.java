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
    private Long hansum;
    private String name;
    private String admission;
    private String graduation;
    private String generation;
    private String major;
    private String work;
    private List<Detail> history;
    private String imgUrl;

    public static UserResponse from(UserDto userDto) {
        return UserResponse.builder()
                .hansum(userDto.getHansum())
                .name(userDto.getName())
                .work(userDto.getWork())
                .major(userDto.getMajor())
                .history(userDto.getHistory())
                .imgUrl(userDto.getImgUrl())
                .generation(userDto.getGeneration())
                .admission(userDto.getAdmission())
                .graduation(userDto.getGraduation())
                .build();
    }
}
