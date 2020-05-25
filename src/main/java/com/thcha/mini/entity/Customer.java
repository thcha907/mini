package com.thcha.mini.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.Inheritance;
// import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(includeNames = true)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "customerType")
//public abstract class Customer {
public class Customer {
    
    @Id @GeneratedValue
    @Column(name="customer_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String lineCount;

    private String customerType;

    private String personSsn;
    private String personPhoneNo;

    private String companyBizNo;
    private String companyRepName;
    private String companyPhoneNo;

    @OneToMany(mappedBy = "customer")
    private List<Claim> claims = new ArrayList<Claim>();

    public Customer(String name) {
        this(name, "PERSON");
    }

    public Customer(String name, String customerType) {
        this(name, "PERSON", "0");
    }

    public Customer(String name, String customerType, String lineCount) {
        this.name = name;
        this.customerType = customerType;
        this.lineCount = lineCount;
    }
}