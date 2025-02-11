package com.example.holiday.user.controller.request;

import com.example.holiday.user.domain.Detail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

    private Long hansum;
    private String name;
    private String admission;
    private String graduation;
    private String work;
    private String major;
    private List<Detail> history;
    //private MultipartFile image;

}

