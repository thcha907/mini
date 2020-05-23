package com.thcha.mini.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERSON")
@Getter @Setter
public class PersonCustomer extends Customer {
    //@Column(name = "person_phone_no")
    private String personSsn;

    @Column(name = "person_phone_no")
    private String personPhoneNo;
}