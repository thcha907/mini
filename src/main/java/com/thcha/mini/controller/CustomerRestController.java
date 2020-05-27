package com.thcha.mini.controller;

// import java.net.URI;
// import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.thcha.mini.dto.AddressDto;
import com.thcha.mini.dto.CustomerDto;
import com.thcha.mini.dto.CustomerRestReturnDto;
import com.thcha.mini.dto.Data;
import com.thcha.mini.dto.RestApiResult;
import com.thcha.mini.dto.RestCustomerDto;
import com.thcha.mini.entity.Address;
import com.thcha.mini.entity.Customer;
import com.thcha.mini.repository.CustomerRepository;
import com.thcha.mini.service.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    // @PostConstruct  // 테스트 용도로만 사용 할 것 
    // public void init() {
    //     for (int i = 0; i < 100; i++) {
    //         customerRepository.save(new Customer("Customer"+i, Integer.toString(i)));
    //     }
    // }


    @GetMapping("/customer")
    @ResponseBody
    public CustomerRestReturnDto findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        
        CustomerRestReturnDto returnDto = makeRestReturnDto(customers);
        
        return returnDto;
    }

    @GetMapping("/customer/{id}")
    public CustomerRestReturnDto findById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).get();
        
        CustomerRestReturnDto returnDto = makeRestReturnDto(new ArrayList<>(Arrays.asList(new Customer[]{customer})));
        
        //List<Customer> customers = new ArrayList<Customer>();
        //customers.add(customer);
        //CustomerRestReturnDto returnDto = makeRestReturnDto(customers);
        
        return returnDto;
    }

    public CustomerRestReturnDto makeRestReturnDto(List<Customer> customers) {       

        CustomerRestReturnDto returnDto = new CustomerRestReturnDto();
        
        if (!customers.isEmpty()) {
            returnDto.setCount(customers.size());
            for (Customer customer : customers) {
                Data data = new Data();

                data.setId(customer.getId()); 
                data.setName(customer.getName()); 
                data.setAddress(new AddressDto(customer.getAddress().getCity(), customer.getAddress().getStreet(), customer.getAddress().getZipcode()));
                data.setLineCount(customer.getLineCount());
                data.setHandphone(customer.getCustomerType().equalsIgnoreCase("PERSON") ? customer.getPersonPhoneNo() : customer.getCompanyPhoneNo());
            
                returnDto.addListData(data);
            }
        }
        
        return returnDto;
    }


    @GetMapping("/customerPaged")
    public Page<CustomerDto> customerPaged(@PageableDefault(size = 3) Pageable pageable ) {
        Page<Customer> page = customerRepository.findAll(pageable);
        Page<CustomerDto> pageDto = page.map(customer -> new CustomerDto(customer.getId(), customer.getName(),customer.getLineCount()));

        return pageDto;
    }

    @PostMapping("/customer")
    //@ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public RestApiResult postSave(@RequestBody RestCustomerDto restCustomerDto) {
    //public ResponseEntity<RestApiResult> postSave(@RequestBody RestCustomerDto restCustomerDto) throws URISyntaxException {

        RestApiResult restApiResult = new RestApiResult();
        Customer customer = new Customer();
        Address address = new Address(restCustomerDto.getCity(), restCustomerDto.getStreet(), restCustomerDto.getZipcode());

        customer.setName(restCustomerDto.getName());
        customer.setAddress(address);
        customer.setLineCount(restCustomerDto.getLineCount());
        customer.setCustomerType(restCustomerDto.getCustomerType());

        Customer savedCustomer = customerService.save(customer);

        if (savedCustomer.getId().intValue() > 0) {
            restApiResult.success(1, "");
        } else {
            restApiResult.failure(0, "오류가 발생 하였습니다.");
        }

        // URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        //         .path("/")
        //         .buildAndExpand(RestApiResult)
        //         .toUri();

        //return ResponseEntity.created(uri).body(RestApiResult);
        return restApiResult;
    }    

    @PutMapping("/customer/{id}")
    //@ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public RestApiResult putUpdate(@PathVariable Long id, @RequestBody RestCustomerDto restCustomerDto) {
    //public ResponseEntity<RestApiResult> postSave(@RequestBody RestCustomerDto restCustomerDto) throws URISyntaxException {

        RestApiResult restApiResult = new RestApiResult();

        if (id == null) {
            restApiResult.failure(0, "변경할 고객 ID 정보가 Null 입니다.");
            return restApiResult;
        }

        String personPhoneNo = restCustomerDto.getPersonPhoneNo();

        if (personPhoneNo == null || personPhoneNo.isEmpty()) {
            restApiResult.failure(0, "변경할 전화변호가 null 입니다.");
            return restApiResult;
        }

        Customer customer = customerService.findById(id);

        if (customer == null || customer.getId() <= 0) {
            restApiResult.failure(0, "미들록 고객 ID 입니다. ("+ id +")");
        } else {
            customer.setPersonPhoneNo(personPhoneNo);

            Customer savedCustomer = customerService.save(customer);

            if (savedCustomer.getId().intValue() == customer.getId().intValue()) {
                restApiResult.success(1, "");
            } else {
                restApiResult.failure(0, "전화번호 변경 중 오류가 발생 했습니다.");
            }
        }

        // URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        //         .path("/")
        //         .buildAndExpand(RestApiResult)
        //         .toUri();

        //return ResponseEntity.created(uri).body(RestApiResult);
        return restApiResult;
    }    

    @DeleteMapping("/customer/{id}")
    //@ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public RestApiResult delete(@PathVariable Long id) {
    //public ResponseEntity<RestApiResult> postSave(@RequestBody RestCustomerDto restCustomerDto) throws URISyntaxException {

        RestApiResult restApiResult = new RestApiResult();

        if (id == null) {
            restApiResult.failure(0, "변경할 고객 ID 정보가 Null 입니다.");
            return restApiResult;
        }

        Long deletedId = customerService.delete(id);

        if (deletedId.intValue() == id.intValue()) {
            restApiResult.success(1, "");
        } else {
            restApiResult.failure(0, "고객정보 삭제 중 오류가 발생 했습니다. (" + id + ")");
        }

        // URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        //         .path("/")
        //         .buildAndExpand(RestApiResult)
        //         .toUri();

        //return ResponseEntity.created(uri).body(RestApiResult);
        return restApiResult;
    }    

}