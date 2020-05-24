package com.thcha.mini.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customerType")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(includeNames = true)
public abstract class Customer {
    
    @Id @GeneratedValue
    @Column(name="customer_id")
    private Long id;

    private String name;

    //@Column(name="customer_type")
    //private String cType;

    @Embedded
    private Address address;

    private String lineCount;

    @OneToMany(mappedBy = "customer")
    private List<Claim> claims = new ArrayList<Claim>();
}