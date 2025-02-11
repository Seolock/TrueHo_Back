package com.example.holiday.user.controller.response;


import com.example.holiday.user.domain.Detail;
import com.example.holiday.user.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HansumResponse {

    private Long id;
    private String name;
    private String major;
    private String work;
    private List<Detail> history;
    private String imgUrl;


    public static HansumResponse from(UserDto userDto) {
        return HansumResponse.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .work(userDto.getWork())
                .history(userDto.getHistory())
                .major(userDto.getMajor())
                .imgUrl(userDto.getImgUrl())
                .build();
    }
}
