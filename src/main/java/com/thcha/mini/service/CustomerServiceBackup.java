package com.thcha.mini.service;

// import java.util.ArrayList;
// import java.util.List;

// import com.thcha.mini.dto.CustomersDto;
// import com.thcha.mini.entity.CompanyCustomer;
// import com.thcha.mini.entity.Customer;
// import com.thcha.mini.entity.PersonCustomer;
// import com.thcha.mini.repository.CompanyCustomerRepository;
// import com.thcha.mini.repository.CustomerRepository;
// import com.thcha.mini.repository.PersonCustomerRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import lombok.RequiredArgsConstructor;

// @Service
// @Transactional(readOnly = true)
// @RequiredArgsConstructor
public class CustomerServiceBackup {

    // @Autowired
    // private final CustomerRepository customerRepository;
    // private final PersonCustomerRepository personCustomerRepository;
    // private final CompanyCustomerRepository companyCustomerRepository;

    // @Transactional
    // /**
    //  * 고객정보 신규 등록
    //  * @param customer
    //  * @return
    //  */
    // public Long save(Customer customer) {
    //     validateDuplicationCusomer(customer);
    //     customerRepository.save(customer);
    //     return customer.getId();
    // }

    // @Transactional
    // /**
    //  * 고객정보 변경
    //  * 영속성 객체를 flush를 하지 않아도, @Transactional에 의해 commit이 발생하여
    //  * DB에 반영이 됨
    //  * @param customerId
    //  * @param customer
    //  */
    // public void update(Long customerId, Customer customer) {
    //     Customer findCustomer = customerRepository.findOne(customerId);

    //     findCustomer.setName(customer.getName());
    //     findCustomer.setLineCount(customer.getLineCount());
    //     findCustomer.setAddress(customer.getAddress());
    // }
    // /**
    //  * Validation 
    //  * Customer Type에 따라 아래와 같이 Validation을 수행 한다.
    //  * - PERSON  : 주민등록번호 확인
    //  * - COMPANY : 사업자번호 확인
    //  */
    // private void validateDuplicationCusomer(Customer customer) {
        
    //     if (customer instanceof PersonCustomer) {
    //         List<Customer> findCustomers = customerRepository.findByName(customer.getName());
    //         if (!findCustomers.isEmpty()) {
    //             throw new IllegalStateException("이미 등록된 회원입니다.");
    //         }
    //     } else {

    //     }
    // }

    // public List<Customer> findCustoemrs() {
    //     return customerRepository.findAll();
    // }

    // public Customer findOne(Long customerId) {
    //     return customerRepository.findOne(customerId);
    // }

    // public List<Customer> findByName(String name) {
    //     return customerRepository.findByName(name);
    // }

    // public List<Customer> findByPersonSsn(String personSsn) {
    //     return customerRepository.findByPersonSsn(personSsn);
    // }

    // public List<Customer> findByCompanyBizNo(String companyBizNo) {
    //     return customerRepository.findByCompanyBizNo(companyBizNo);
    // }

    // /**
    //  * 조회 조건으로 고객명, 고객구분을 받아서, 리스트로 조회할 정보를 customersDto로 반환한 한다.
    //  * @param custoemrName
    //  * @param customerType
    //  * @param model
    //  * @return String 고객조회 html
    //  */
    // public List<CustomersDto> retrieveCustomerList(String custoemrName, String customerType)  {

    //     List<CustomersDto> customersDto = new ArrayList<CustomersDto>();

    //     List<PersonCustomer> personCustomers = null; 
    //     List<CompanyCustomer> companyCustomers = null;        

    //     if (customerType == null || custoemrName.isEmpty()) {
    //         if (custoemrName == null || custoemrName.isEmpty()) {
    //             personCustomers = personCustomerRepository.findAll(); 
    //             companyCustomers = companyCustomerRepository.findAll(); 
    //         } else {
    //             personCustomers = personCustomerRepository.findByName(custoemrName); 
    //             companyCustomers = companyCustomerRepository.findByName(custoemrName); 
    //         }
    //     } else {
    //         if (customerType.equalsIgnoreCase("PERSON")) {
    //             if (custoemrName == null || custoemrName.isEmpty()) {
    //                 personCustomers = personCustomerRepository.findAll(); 
    //             } else {
    //                 personCustomers = personCustomerRepository.findByName(custoemrName); 
    //             }
    //         } else {
    //             if (custoemrName == null || custoemrName.isEmpty()) {
    //                 companyCustomers = companyCustomerRepository.findAll(); 
    //             } else {
    //                 companyCustomers = companyCustomerRepository.findByName(custoemrName); 
    //             }
    //         }
    //     }

    //     if (personCustomers != null) {
    //         for (Customer customer : personCustomers) {
    //             CustomersDto cDto = new CustomersDto();
    
    //             cDto.setCusomterType("PERSON");
    
    //             cDto.setId(customer.getId());
    //             cDto.setName(customer.getName());
    //             cDto.setLineCount(customer.getLineCount());
    
    //             cDto.setAddress(customer.getAddress().getZipcode() +" "+
    //                 customer.getAddress().getCity() +" "+
    //                 customer.getAddress().getStreet());
    
    //             customersDto.add(cDto);
    //         }
    //     }

    //     if (companyCustomers != null) {
    //         for (Customer customer : companyCustomers) {
    //             CustomersDto cDto = new CustomersDto();
    
    //             cDto.setCusomterType("COMPANY");
    
    //             cDto.setId(customer.getId());
    //             cDto.setName(customer.getName());
    //             cDto.setLineCount(customer.getLineCount());
    
    //             cDto.setAddress(customer.getAddress().getZipcode() +" "+
    //                 customer.getAddress().getCity() +" "+
    //                 customer.getAddress().getStreet());
    
    //             customersDto.add(cDto);
    //         }
    //     }

    //     return customersDto;
    // }
}
