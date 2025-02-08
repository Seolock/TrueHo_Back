package com.example.holiday.user.controller.response;

import com.example.holiday.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserResponse {
    private String name;
    private String studentId;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;
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
                .build();

    }
}
