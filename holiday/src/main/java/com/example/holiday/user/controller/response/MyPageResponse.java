package com.example.holiday.user.controller.response;

import com.example.holiday.user.dto.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageResponse {
    private String name;
    private Long showing;
    private String imgUrl;

    public static MyPageResponse from(UserDto userDto){
        return MyPageResponse.builder()
                .name(userDto.getName())
                .showing(userDto.getShowing())
                .imgUrl(userDto.getImgUrl())
                .build();
    }

}
