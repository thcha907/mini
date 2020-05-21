package com.thcha.mini.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import groovy.transform.ToString;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(includeNames = true)
public class Visit {
    @Id @GeneratedValue
    @Column(name = "visit_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;
    //private List<Engineer> engineers = new ArrayList<Engineer>();

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "visit_time_cd")
    private String visitTimeCd;

    @Column(name = "claim_process_desc")
    private String claimProcessDesc;
}