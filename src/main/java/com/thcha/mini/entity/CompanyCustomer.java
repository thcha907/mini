package com.thcha.mini.entity;

//import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("COMPANY")
@Getter @Setter
public class CompanyCustomer extends Customer {
    //@Column(name = "company_biz_no")
    private String companyBizNo;

    //@Column(name = "company_rep_name")
    private String companyRepName;

    //@Column(name = "compny_phone_no")
    private String companyPhoneNo;
}