package com.thcha.mini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import com.thcha.mini.config.MessageConfig;
import com.thcha.mini.dto.CustomerDto;
import com.thcha.mini.dto.CustomerSearchDto;
import com.thcha.mini.dto.CustomersDto;
import com.thcha.mini.entity.Address;
import com.thcha.mini.entity.Customer;
import com.thcha.mini.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customer/newForm")
    /**
     * 신규 고객 등록 화면을 그리기 위한 요청 처리
     * 빈 customerDto를 model Attribute로 반환하여 화면을 그린다.
     * @param model
     * @return String 고객 등록 화면 html
     */
    public String newForm(Model model) {
        log.info(this.getClass().getName() + ".newForm start ...");

        model.addAttribute("customerDto", new CustomerDto());
        return "customer/registCustomer";
    }

    @GetMapping("/customer/{id}/updateForm")
    /**
     * Customer ID를 받아서 customer 정보를 customerDto로 전달하여
     * 화면에 조회하기 위한 메소드
     * @param form
     * @param result
     * @return String 저장 후 redirect menu로 분기 처리
     */
    public String updateForm(@PathVariable("id") Long customerId, Model model) {
        log.info(this.getClass().getName() + ".updateForm start ...");

        Customer customer = customerService.findById(customerId);
        
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
        return "customer/registCustomer";
    }


    @PostMapping("/customer/saveCustomer")
    /**
     * 화면에 조회된 정보를 저장하기 위한 메소드
     * @param form
     * @param result
     * @param request
     * @param model
     * @return String 저장 후 고객조회 화면으로 이동하기 위한 redirect path
     */
    public String saveCustomer(@Valid CustomerDto form, BindingResult result, final HttpServletRequest request, Model model) {
        log.info(this.getClass().getName() + ".saveCustomer start ...");

        //Validate 수행시 에러가 발생하여 comment 처리 함
        //validate(form, result);

        if (result.hasErrors()) {
            return "customer/registCustomer";
        }

        Customer customer = null;
        if (form.getId() == null) {
            customer = new Customer();
        } else {
            customer = customerService.findById(form.getId());
        }

        customer.setName(form.getName());

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        customer.setAddress(address);

        customer.setLineCount(form.getLineCount());

        String companyType = form.getCustomerType().toUpperCase();
        customer.setCustomerType(companyType);

        if (companyType.equalsIgnoreCase("PERSON")) {
            customer.setPersonSsn(form.getPersonSsn());
            customer.setPersonPhoneNo(form.getPersonPhoneNo());
    
            customer.setCompanyBizNo(null);
            customer.setCompanyRepName(null);
            customer.setCompanyPhoneNo(null);
        } else {
            customer.setPersonSsn(null);
            customer.setPersonPhoneNo(null);

            customer.setCompanyBizNo(form.getCompanyBizNo());
            customer.setCompanyRepName(form.getCompanyRepName());
            customer.setCompanyPhoneNo(form.getCompanyPhoneNo());
        }

        Customer savedCustomer = customerService.save(customer);

        log.info(">>> customerService.save(customer) check - id: "+ customer.getId() + "-"+ savedCustomer.getId());
        log.info(">>> name: "+ customer.getName() + "-"+ savedCustomer.getName());
        log.info(">>> customerType: "+ customer.getCustomerType() + "-"+ savedCustomer.getCustomerType());

        CustomerSearchDto customerSearchDto = new CustomerSearchDto(null,form.getCustomerType());
        List<CustomersDto> customersDto = customerService.findAllCustoemrsDto(null, form.getCustomerType());        
        
        model.addAttribute("customerSearchDto", customerSearchDto);
        model.addAttribute("customersDto", customersDto);

        log.info(">>> customersDto.size(): "+ customersDto.size());
        for(CustomersDto cDto : customersDto) {
            log.info(">>> customerService.findAllCustoemrsDto(null, form.getCustomerType()) - id: "+ cDto.getId());
            log.info(">>> name: "+ cDto.getName());
            log.info(">>> customerType: "+ cDto.getCustomerType());    
        }

        return "customer/retrieveCustomer";
    }

    

    /**
     * custoemr 정보 Validation
     * 공통 Field가 Not null Check
     * @param form
     * @param result
     */
    private void validate(@Valid CustomerDto form, BindingResult result) {
        log.info(this.getClass().getName() + ".validate start ...");

        if (form.getCustomerType().equalsIgnoreCase("PERSON")) {
            if (customerService.includeCustomerId(customerService.findByPersonSsn(form.getPersonSsn()), form.getId())) {
                // log.error(form.getId() + " >>> 주민등록번호 등록 여부 확인 >>> Start");
                // FieldError fieldError = new FieldError("customerDto", "personSsn", "이미 등록된 주민등록번호 입니다.");
                // result.addError(fieldError);
                // log.error(form.getId() + " >>> 주민등록번호 등록 여부 확인 >>> End");

                result.addError(new FieldError("cuatomerDto", "personSsn", "이미 등록된 주민등록번호 입니다.")); 
            }
            // if (customerService.findByPersonSsn(form.getPersonSsn()).isEmpty()) {
            //     result.addError(new FieldError("customerForm", "personSsn", "이미 등록된 주민등록번호 입니다.")); 
            //         //MessageConfig.getMessage("error.duplicate", new String[] {MessageConfig.getMessage("label.person_ssn")})));
            // }
        } else {
            if (customerService.includeCustomerId(customerService.findByCompanyBizNo(form.getCompanyBizNo()), form.getId())) {
                result.addError(new FieldError("cuatomerDto", "companyBizNo", "이미 등록된 사업자번호 입니다.")); 
                // log.error(form.getId() + " >>> 사업자번호 등록 여부 확인 >>> Start");
                // FieldError fieldError = new FieldError("customerDto", "companyBizNo", "이미 등록된 사업자번호 입니다.");
                // result.addError(fieldError);
                // log.error(form.getId() + " >>> 사업자번호 등록 여부 확인 >>> Start");
            }
            // if (customerService.findByCompanyBizNo(form.getCompanyBizNo()).isEmpty()) {
            //     result.addError(new FieldError("customerForm", "companyBizNo", 
            //         "고객구분이 'COMPANY'이면 사업자번호는 필수입력 항목 입니다.")); 
            //         //MessageConfig.getMessage("error.duplicate", new String[] {MessageConfig.getMessage("label.company_biz_no")})));
            // }
        }

        return;
    }

    @GetMapping("/customer/retrieveForm")
    /**
     * 초기 고객 조회 화면을 구성하기 위한 정보를 생성하여 반환한다. 
     * @param model
     * @return String 고객조회 html
     */
    public String retrieveForm(Model model) {
        log.info(this.getClass().getName() + ".retrieveForm start ...");

        //List<Customer> customers = customerService.findCustoemrs();

        model.addAttribute("customerSearchDto", new CustomerSearchDto());
        model.addAttribute("customersDto", new ArrayList<CustomersDto>());

        return "customer/retrieveCustomer";
    }

    @PostMapping("/customer/retrieveSearchForm")
    /**
     * 조회 조건으로 고객명, 고객구분을 받아서 customer 정보를 Form에서 조회할 수 있도록 customersDto로 변환하여 반환한다.
     * @param name
     * @param customerType
     * @param searchForm 조회조건 From
     * @param model
     * @return String 고객조회용 Form html
     */
    public String retrieveCustomerList(CustomerSearchDto searchForm, Model model) {
    // @RequestParam("name") String name,
    //         @RequestParam("customerType") String customerType, CustomerSearchDto searchForm, Model model) {
        log.info(this.getClass().getName() + ".retrieveCustomerList start ...");

        List<CustomersDto> customersDto = customerService.findAllCustoemrsDto(searchForm.getName(), searchForm.getCustomerType());        

        model.addAttribute("customersSearchDto", searchForm);
        model.addAttribute("customersDto", customersDto);

        return "customer/retrieveCustomer";
    }
}