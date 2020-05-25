package com.thcha.mini.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;   
    private String lineCount;
    private String cusomterType;
    private String personSsn;
    private String personPhoneNo;
    private String companyBizNo;
    private String companyRepName;
    private String companyPhoneNo;

}