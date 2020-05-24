package com.thcha.mini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Engineer {

    @Id @GeneratedValue
    @Column(name = "engineer_id")
    private Long id;

    @Column(name = "engineer_name")
    private String name;

    private String photoFileName;
    private String phoneNo;
    private String areaCd;
    private String useYn;
}