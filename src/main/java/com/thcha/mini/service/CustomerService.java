package com.thcha.mini.service;

import java.util.ArrayList;
import java.util.List;

import com.thcha.mini.dto.CustomersDto;
import com.thcha.mini.entity.Customer;
import com.thcha.mini.repository.CustomerRepository;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// import java.util.ArrayList;
// import java.util.List;

// import com.thcha.mini.dto.CustomersDto;
// import com.thcha.mini.entity.CompanyCustomer;
// import com.thcha.mini.entity.Customer;
// import com.thcha.mini.entity.PersonCustomer;
// import com.thcha.mini.repository.CompanyCustomerRepository;
// import com.thcha.mini.repository.CustomerRepository;
// import com.thcha.mini.repository.PersonCustomerRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    } 

    @Transactional
    public Long delete(Long customerId) {
        customerRepository.deleteById(customerId);
        return customerId;
    }
    
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findOne(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> findByPersonSsn(String personSsn) {
        return customerRepository.findByPersonSsn(personSsn);
    }

    public List<Customer> findByCompanyBizNo(String companyBizNo) {
        return customerRepository.findByCompanyBizNo(companyBizNo);
    }

    /**
     * 조회 조건으로 고객명, 고객구분을 받아서, 리스트로 조회할 정보를 customersDto로 반환한 한다.
     * @param custoemrName
     * @param customerType
     * @return List<CustomersDto> 고객 정보 조회요 DTO List
     */
    public List<CustomersDto> findAllCustoemrsDto(String custoemrName, String customerType) {

        List<CustomersDto> customersDto = new ArrayList<CustomersDto>();
        List<Customer> customers = null;

        customers = customerRepository.findCustomerCustom(custoemrName, customerType); 

        if (customers != null) {
            for (Customer customer : customers) {
                CustomersDto cDto = new CustomersDto();
    
                cDto.setCustomerType(customer.getCustomerType());
    
                cDto.setId(customer.getId());
                cDto.setName(customer.getName());
                cDto.setLineCount(customer.getLineCount());
    
                cDto.setAddress(customer.getAddress().getZipcode() +" "+
                    customer.getAddress().getCity() +" "+
                    customer.getAddress().getStreet());
    
                customersDto.add(cDto);
            }
        }

        return customersDto;
    }


    /**
     * Customer List 중에서 customer id를 제외하고 Record 존재여부를 파악하여 true를 반환 함
     * 비교할 customer id 또는 customer List가 null이면 false로 반환하고,
     * customer list에 비교할 customer id와 다른 값이 있으면 true를 반환 한다.
     * customer list는 비교할 ID를 포함한 
     */
    public boolean includeCustomerId(List<Customer> customers, Long  id) {
        if (id == null) {
            return false;
        }

        if (customers == null || customers.isEmpty()) {
            return false;
        }

        for (Customer customer : customers) {
            if (customer.getId().intValue() != id.intValue()) {
                return true;
            }
        }

        return false;
    }


    public List<Customer> findAllPage(int age, Pageable pageable) {
        //List<Customer> customers = customerRepository.findAllPage() findByAge(int age, Pageable pageable);
        return null;
    }

}
