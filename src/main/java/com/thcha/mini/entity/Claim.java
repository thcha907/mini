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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Claim {
    @Id @GeneratedValue
    @Column(name = "claim_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime claimDttm;

    private String claimDesc;

    @Enumerated(EnumType.STRING)
    private ClaimProcessStatus status; //ENUM [ACCEPT(접수), COMPLETE(완료)]

    private int claimProcessFee;

    @OneToOne(optional = true)
    @JoinColumn(name = "visit_id")
    private Visit visit;
}