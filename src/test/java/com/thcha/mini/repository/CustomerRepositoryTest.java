package com.thcha.mini.repository;

import java.util.List;

import com.thcha.mini.entity.Customer;

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
@Transactional
@Rollback(false)
public class CustomerRepositoryTest {

    @Autowired //(required = true)
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testCustomer() throws Exception {
        Customer customerA = new Customer("customer A","PERSON", "1");
        Customer customerB = new Customer("customer Company","COMPANY", "20");
        customerRepository.save(customerA);
        customerRepository.save(customerB);

        Customer findCustomerA = customerRepository.findById(customerA.getId()).get();
        Customer findCustomerB = customerRepository.findById(customerB.getId()).get();

        Assertions.assertThat(findCustomerA).isEqualTo(customerA);
        Assertions.assertThat(findCustomerB).isEqualTo(customerB);

        List<Customer> all = customerRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);

        long count = customerRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        customerRepository.delete(customerA);
        customerRepository.delete(customerB);
        
        long deleteCount = customerRepository.count();
        Assertions.assertThat(deleteCount).isEqualTo(0);
    }
}