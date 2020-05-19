package com.thcha.mini.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("C")
@Getter @Setter
public class CompanyCustomer extends Customer {
    @Column(name = "biz_no")
    private String bizNo;

    @Column(name = "rep_name")
    private String repName;

    @Column(name = "compny_phone_no")
    private String companyPhoneNo;
}