package com.thcha.mini.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomersDto {
    private Long id;
    private String name;
    private String customerType;
    private String address;
    private String lineCount;
}