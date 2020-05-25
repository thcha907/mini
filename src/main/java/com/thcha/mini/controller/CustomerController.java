package com.thcha.mini.controller;

import com.thcha.mini.dto.CustomerDto;
// import com.thcha.mini.dto.CustomersDto;
import com.thcha.mini.entity.Customer;
import com.thcha.mini.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

    @Autowired(required = false)
    private CustomerRepository customerRepository;
    
    @GetMapping("/customer/newForm")
    /**
     * 신규 고객 등록 화면을 그리기 위한 요청 처리
     * 빈 customerDto를 model Attribute로 반환하여 화면을 그린다.
     * @param model
     * @return String 고객 등록 화면 html
     */
    public String newForm(Model model) {
        log.info("CustomerController.createRegistCustomerForm start ...");

        model.addAttribute("customerDto", new CustomerDto());
        return "recustomer/registCustomer";
    }

    @PostMapping("/customer/{customerId}/updateForm")
    /**
     * Customer ID를 받아서 
     * @param form
     * @param result
     * @return String 저장 후 redirect menu로 분기 처리
     */
    public String updateForm(@PathVariable("customerId") Long customerId, Model model) {

        Customer customer = customerRepository.findById(customerId).get();
        
        CustomerDto customerDto = 
            new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAddress().getCity(),
                customer.getAddress().getStreet(),
                customer.getAddress().getZipcode(),
                customer.getLineCount(),
                customer.getCustomerType(),
                customer.getPersonSsn(),
                customer.getPersonPhoneNo(),
                customer.getCompanyBizNo(),
                customer.getCompanyRepName(),
                customer.getCompanyPhoneNo()
            );

        model.addAttribute("customerDto", customerDto);
        return "recustomer/registCustomer";
    }

    // @GetMapping("/customer/retrieveCustomerCustom")
    // public Page<Customer> retrieveCustomerCustom(Pageable pageable) {
    //     Page<Customer> page = customerRepository.

    // }

}