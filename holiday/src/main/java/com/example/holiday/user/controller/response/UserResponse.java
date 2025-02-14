package com.example.holiday.user.controller.response;

import com.example.holiday.user.domain.Detail;
import com.example.holiday.user.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.HashMap;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Long showing;

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
                .showing(userDto.getShowing())
                .build();
    }
}
