package com.example.holiday.user.controller.response;

import com.example.holiday.user.domain.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponse {

    private String name;
    private String imgUrl;

    public static UserProfileResponse profileEtoR(User user) {
        return UserProfileResponse.builder()
                .name(user.getName())
                .imgUrl(user.getImgUrl())
                .build();
    }
}
