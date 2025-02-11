package com.example.holiday.user.controller.response;

import com.example.holiday.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyPageResponse {
    private String name;
    private Long state;
    private String imgUrl;

    public static MyPageResponse from(UserDto userDto){
        return MyPageResponse.builder()
                .name(userDto.getName())
                .state(userDto.getState())
                .imgUrl(userDto.getImgUrl())
                .build();
    }

}
