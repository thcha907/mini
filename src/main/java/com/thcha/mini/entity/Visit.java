package com.thcha.mini.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Visit {
    @Id @GeneratedValue
    @Column(name = "visit_id")
    private Long id;

    private Claim claim;
    private Engineer engineer;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "visit_time_cd")
    private String visitTimeCd;

    @Column(name = "claim_process_desc")
    private String claimProcessDesc;
}