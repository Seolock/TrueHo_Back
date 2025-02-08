package com.example.holiday.user.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter

public class UserRequest {

    private String name;
    private String studentId;
    private String work;
    private String company;
    private String oneLine;
    private String detail;
    private String academy;
    private String licence;


    public UserRequest(String name, String studentId, String work, String company, String oneLine, String detail, String academy, String licence) {
        this.name = name;
        this.studentId = studentId;
        this.work = work;
        this.company = company;
        this.oneLine = oneLine;
        this.detail = detail;
        this.academy = academy;
        this.licence = licence;

    }
}


