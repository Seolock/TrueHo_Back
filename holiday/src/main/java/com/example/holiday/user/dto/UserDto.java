package com.example.holiday.user.dto;

import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.domain.Detail;
import com.example.holiday.user.domain.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private Long showing;
    private Long hansum;
    private String name;
    private String admission;
    private String graduation;
    private String work;
    private String major;
    private List<Detail> history;
    private String generation;
    private String imgUrl;


    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .hansum(user.getHansum())
                .showing(user.getShowing())
                .name(user.getName())
                .work(user.getWork())
                .major(user.getMajor())
                .history(user.getHistory())
                .imgUrl(user.getImgUrl())
                .generation(user.getGeneration())
                .admission(user.getAdmission())
                .graduation(user.getGraduation())
                .build();
    }

}
