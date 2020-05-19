package com.thcha.mini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Engineer {
    @Id @GeneratedValue
    @Column(name = "engineer_id")
    private Long id;

    @Column(name = "engineer_name")
    private String name;

    @Column(name = "photo_file_name")
    private String photoFileName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "area_cd")
    private String areaCd;

    @Column(name = "use_yn")
    private String useYn;
}