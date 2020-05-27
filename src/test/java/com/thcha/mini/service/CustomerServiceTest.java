package com.thcha.mini.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

import java.util.List;

import com.thcha.mini.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerServiceTest {
    
    @Autowired
    CustomerService customerService;

    @Test
    public void save() {
        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");

        Customer saveCustomerA = customerService.save(customerA);
        assertEquals(customerA, customerService.findById(saveCustomerA.getId()));

        customerService.save(customerB);
        customerService.save(customerC);

         List<Customer> customers = customerService.findAll();
         Assertions.assertThat(customers.size()).isEqualTo(3);
    }
}