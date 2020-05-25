package com.thcha.mini.repository;

import com.thcha.mini.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends  JpaRepository <Customer, Long>, CustomerRepositoryCustom {
}