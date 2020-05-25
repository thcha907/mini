package com.thcha.mini.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustoemrTest {
    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(true) //false로 하면 테스트가 안돼서 true로 변경하고 테스트를 진행 함
    public void testCutomer() {
        Customer customerA = new Customer("customer A","PERSON", "1");
        Customer customerB = new Customer("customer Company","COMPANY", "20");
        Customer customerC = new Customer("customer C","PERSON", "1");

        em.persist(customerA);
        em.persist(customerB);
        em.persist(customerC);

        //초기화
        em.flush();
        em.clear();

        //확인
        List<Customer> customers = em.createQuery("select c from Customer c", Customer.class)
            .getResultList();

        for (Customer customer : customers) {
            System.out.println("Customer=" + customer.toString());
        }
    }
}