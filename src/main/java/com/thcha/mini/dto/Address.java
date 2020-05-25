package com.thcha.mini.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;
}