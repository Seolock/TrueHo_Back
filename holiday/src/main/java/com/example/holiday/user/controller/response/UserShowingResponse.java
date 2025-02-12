package com.example.holiday.user.controller.response;

import com.example.holiday.user.dto.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserShowingResponse {
    private Long showing;

    public static UserShowingResponse from(UserDto userDto) {
        return UserShowingResponse.builder().showing(userDto.getShowing()).build();
    }
}
