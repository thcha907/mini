package com.thcha.mini.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RestApiResult {
    private int count;
    private String status;
    private String message; 

    public void success(int count, String message) {
        this.count = count;
        this.status = "SUCCESS";
        this.message = message; 
    }

    public void failure(int count, String message) {
        this.count = count;
        this.status = "FAILURE";
        this.message = message; 
    }
}