package com.example.holiday.user.controller.response;


import com.example.holiday.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HansumResponse {

    private Long id;
    private String name;
    private String major;
    private String work;
    private String detail;
    private String imgUrl;


    public static HansumResponse from(UserDto userDto) {
        return HansumResponse.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .work(userDto.getWork())
                .detail(userDto.getDetail())
                .major(userDto.getMajor())
                .imgUrl(userDto.getImgUrl())
                .build();

    }
}
