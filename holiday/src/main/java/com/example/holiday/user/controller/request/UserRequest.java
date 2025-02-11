package com.example.holiday.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

    private Long hansum;
    private String name;
    private String studentId;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;
    private String major;
    //private MultipartFile image;

}

