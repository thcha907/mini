package com.thcha.mini.dto;

//import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerDto {

    private Long id;

    //@NotEmpty(message = "고객명은 필수 입력입니다.")
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