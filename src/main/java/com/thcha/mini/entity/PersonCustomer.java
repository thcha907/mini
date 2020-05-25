package com.thcha.mini.entity;

//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity를 Customer Entity 하나로 통합하가 위해서 Comment 처리
 */
//@Entity
//@DiscriminatorValue("PERSON")
@Getter @Setter
public class PersonCustomer extends Customer {
    //private String personSsn;
    //private String personPhoneNo;
}