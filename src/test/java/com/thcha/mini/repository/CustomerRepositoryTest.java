package com.thcha.mini.repository;

import com.thcha.mini.entity.Customer;
import com.thcha.mini.entity.PersonCustomer;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testCustomer() throws Exception {
        //Customer customer = new Customer();
        Customer customer = new PersonCustomer();
        customer.setName("customer A");

        Long saveId = customerRepository.save(customer);
        Customer findCustomer = customerRepository.findOne(saveId);
        
        Assertions.assertThat(findCustomer.getId()).isEqualTo(customer.getId());
        Assertions.assertThat(findCustomer.getName()).isEqualTo(customer.getName());
        Assertions.assertThat(findCustomer).isEqualTo(customer);

        System.out.printf("\n>>> --- findCustomer == customer: %s --- <<<\n\n", Boolean.toString(findCustomer == customer));
    }

}