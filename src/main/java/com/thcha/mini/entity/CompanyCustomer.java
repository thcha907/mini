package com.thcha.mini.entity;

//import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity를 Customer Entity 하나로 통합하가 위해서 Comment 처리
 */
//@Entity
//@DiscriminatorValue("COMPANY")
@Getter @Setter
public class CompanyCustomer extends Customer {
    //private String companyBizNo;
    //private String companyRepName;
    //private String companyPhoneNo;
}