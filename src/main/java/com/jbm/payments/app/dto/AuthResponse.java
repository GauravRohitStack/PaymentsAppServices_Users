package com.jbm.payments.app.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
   
}