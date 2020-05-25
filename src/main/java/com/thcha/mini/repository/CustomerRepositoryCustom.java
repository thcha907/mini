package com.thcha.mini.repository;

import java.util.List;

import com.thcha.mini.entity.Customer;


public interface CustomerRepositoryCustom {
    
    public List<Customer> findCustomerCustom(String name, String customerType);
}