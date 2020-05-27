package com.thcha.mini.dto;


import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;

    @NotEmpty(message = "고객명은 필수입력 항목 입니다.")
    private String name;

    @NotEmpty(message = "주소는 필수입력 항목 입니다.")
    private String city;

    @NotEmpty(message = "상세주소는 필수입력 항목 입니다.")
    private String street;

    @NotEmpty(message = "우편번호는 필수입력 항목 입니다.")
    private String zipcode;   

    @NotEmpty(message = "회선수량은 필수입력 항목 입니다.")
    private String lineCount;

    private String customerType;

    private String personSsn;
    private String personPhoneNo;

    private String companyBizNo;
    private String companyRepName;
    private String companyPhoneNo;

    public CustomerDto(Long id, String name, String lineCount) {
        this.id = id;
        this.name = name;
        this.lineCount = lineCount;
    }
}