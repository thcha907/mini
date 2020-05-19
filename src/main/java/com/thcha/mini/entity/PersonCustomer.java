package com.thcha.mini.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("P")
@Getter @Setter
public class PersonCustomer extends Customer {
    private String ssn;

    @Column(name = "phone_no")
    private String phoneNo;
}