package com.thcha.mini.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "claims")
@Getter @Setter
public class Claim {
    @Id @GeneratedValue
    @Column(name = "claim_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "claim_dttm")
    private LocalDateTime claimDttm;

    @Column(name = "claim_desc")
    private String claimDesc;

    @Column(name = "claim_process_status")
    @Enumerated(EnumType.STRING)
    private ClaimProcessStatus status; //ENUM [ACCEPT(접수), COMPLETE(완료)]

    @Column(name = "claim_process_fee")
    private int claimProcessFee;
}