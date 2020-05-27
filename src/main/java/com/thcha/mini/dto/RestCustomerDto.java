package com.thcha.mini.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RestCustomerDto {
    private String name; 

    private String city;
    private String street;
    private String zipcode;
    private String lineCount;

    private String customerType;

    private String personSsn;
    private String personPhoneNo;

    private String companyBizNo;
    private String companyRepName;
    private String companyPhoneNo;
}