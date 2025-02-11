package com.example.holiday.login;

import lombok.Data;

@Data
public class LoginResponse {
    private String state;

    public LoginResponse(String state) {
        this.state = state;
    }
}
