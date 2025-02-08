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
    private Long showing;

    public MyPageResponse from(UserDto userDto){
        return MyPageResponse.builder()
                .name(userDto.getName())
                .showing(userDto.getShowing())
                .build();
    }

}
