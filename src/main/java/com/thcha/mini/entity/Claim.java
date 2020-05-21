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
import javax.persistence.OneToOne;
//import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //@Table(name = "claim")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToOne(optional = true)
    @JoinColumn(name = "visit_id")
    private Visit visit;
}