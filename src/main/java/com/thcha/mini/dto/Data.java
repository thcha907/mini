package com.thcha.mini.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Data {
    private Long id;
    private String name;
    private AddressDto address;
    private String lineCount;
    private String handphone;
}