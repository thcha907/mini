package com.thcha.mini.controller;

// import java.util.ArrayList;
// import java.util.List;

// import javax.validation.Valid;

// import com.thcha.mini.config.MessageConfig;
// import com.thcha.mini.dto.CustomerDto;
// import com.thcha.mini.dto.CustomerSearchDto;
// import com.thcha.mini.dto.CustomersDto;
// import com.thcha.mini.entity.Address;
// import com.thcha.mini.entity.CompanyCustomer;
// import com.thcha.mini.entity.Customer;
// import com.thcha.mini.entity.PersonCustomer;
// //import com.thcha.mini.service.CompanyCustomerService;
// import com.thcha.mini.service.CustomerService;
// //import com.thcha.mini.service.PersonCustomerService;

// //import org.springframework.context.MessageSource;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.FieldError;
// //import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Controller
// @RequiredArgsConstructor
// @Slf4j
public class CustomerControllerBackup {

    // private final CustomerService customerService;
    // //private final PersonCustomerService personCustomerService;
    // //private final CompanyCustomerService companyCustomerService;

    // @GetMapping("/customer/newForm")
    // /**
    //  * 신규 고객 등록 화면을 그리기 위한 요청 처리
    //  * 빈 customerDto를 model Attribute로 반환하여 화면을 그린다.
    //  * @param model
    //  * @return String 고객 등록 화면 html
    //  */
    // public String newForm(Model model) {
    //     log.info("CustomerController.createRegistCustomerForm start ...");

    //     model.addAttribute("customerDto", new CustomerDto());
    //     return "recustomer/registCustomer";
    // }

    // @PostMapping("/customer/{customerId}/updateForm")
    // /**
    //  * Customer ID를 받아서 
    //  * @param form
    //  * @param result
    //  * @return String 저장 후 redirect menu로 분기 처리
    //  */
    // public String updateForm(@PathVariable("customerId") Long customerId, Model model) {

    //     validate(form, result);

    //     if (result.hasErrors()) {
    //         return "customer/registCustomer";
    //     }

    //     Customer customer = null;
    //     if (form.getCustomerType().equalsIgnoreCase("PERSON")) {
    //         customer = new PersonCustomer();
    //     } else {
    //         customer = new CompanyCustomer();
    //     }

    //     customer.setName(form.getName());

    //     Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
    //     customer.setAddress(address);

    //     customer.setLineCount(form.getLineCount());

    //     customerService.save(customer);

    //     return "redirect:/customer/retrieveCustomer";
    // }
    
    // @PostMapping("/customer/registCustomerForm")
    // /**
    //  * 
    //  * @param form
    //  * @param result
    //  * @return String 저장 후 redirect menu로 분기 처리
    //  */
    // public String create(@Valid CustomerDto form, BindingResult result) {

    //     validate(form, result);

    //     if (result.hasErrors()) {
    //         return "customer/registCustomer";
    //     }

    //     Customer customer = null;
    //     if (form.getCustomerType().equalsIgnoreCase("PERSON")) {
    //         customer = new PersonCustomer();
    //     } else {
    //         customer = new CompanyCustomer();
    //     }

    //     customer.setName(form.getName());

    //     Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
    //     customer.setAddress(address);

    //     customer.setLineCount(form.getLineCount());

    //     if (form.getId() == null) {
    //         customerService.save(customer);
    //     } else {
    //         customerService.update(form.getId(), customer);
    //     }

    //     return "redirect:/customer/retrieveCustomer";
    // }

    // @PostMapping("/customer/{customerId}/update")
    // /**
    //  * 
    //  * @param form
    //  * @param result
    //  * @return String 저장 후 redirect menu로 분기 처리
    //  */
    // public String updateGetCustomer(@PathVariable("customerId") Long customerId, @Valid CustomerDto form, BindingResult result) {

    //     validate(form, result);

    //     if (result.hasErrors()) {
    //         return "customer/registCustomer";
    //     }

    //     Customer customer = null;
    //     if (form.getCustomerType().equalsIgnoreCase("PERSON")) {
    //         customer = new PersonCustomer();
    //     } else {
    //         customer = new CompanyCustomer();
    //     }

    //     customer.setName(form.getName());

    //     Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
    //     customer.setAddress(address);

    //     customer.setLineCount(form.getLineCount());

    //     customerService.save(customer);

    //     return "redirect:/customer/retrieveCustomer";
    // }
    
    // /**
    //  * 공통 Field가 Not null Check
    //  * 
    //  * @param form
    //  * @param result
    //  */
    // private void validate(@Valid CustomerDto form, BindingResult result) {

    //     // result.addError(new FieldError(REGISTER, "username",
    //     //              messageSource.getMessage("create.error.username", null, locale)));

    //     if (form.getName().isEmpty()) {
    //         result.addError(new FieldError("customerForm", "name",
    //             MessageConfig.getMessage("error.mandatory", new String[] {MessageConfig.getMessage("label.customer_name")})));
    //     }

    //     if (form.getCity().isEmpty()) {
    //         result.addError(new FieldError("customerForm", "city", 
    //             MessageConfig.getMessage("error.mandatory", new String[] {MessageConfig.getMessage("label.address_city")})));
    //     }

    //     if (form.getStreet().isEmpty()) {
    //         result.addError(new FieldError("customerForm", "street",
    //             MessageConfig.getMessage("error.mandatory", new String[] {MessageConfig.getMessage("label.address_street")})));
    //     }

    //     if (form.getZipcode().isEmpty()) {
    //         result.addError(new FieldError("customerForm", "zipcode", 
    //             MessageConfig.getMessage("error.mandatory", new String[] {MessageConfig.getMessage("label.address_zipcode")})));
    //     }

    //     if (form.getLineCount().isEmpty()) {
    //         result.addError(new FieldError("customerForm", "lineCount", 
    //             MessageConfig.getMessage("error.mandatory", new String[] {MessageConfig.getMessage("label.line_count")})));
    //     }

    //     if (form.getCustomerType().equalsIgnoreCase("PERSON")) {
    //         if (customerService.findByPersonSsn(form.getPersonSsn()).isEmpty()) {
    //             result.addError(new FieldError("customerForm", "personSsn", 
    //                 MessageConfig.getMessage("error.duplicate", new String[] {MessageConfig.getMessage("label.person_ssn")})));
    //         }
    //     } else {
    //         if (customerService.findByCompanyBizNo(form.getCompanyBizNo()).isEmpty()) {
    //             result.addError(new FieldError("customerForm", "companyBizNo", 
    //                 MessageConfig.getMessage("error.duplicate", new String[] {MessageConfig.getMessage("label.company_biz_no")})));
    //         }
    //     }
    // }


    // /**
    //  * Handle the create account form submission.
    //  * 
    //  * @param register the register form bean
    //  * @param binding  the binding result
    //  * @param request  the HTTP servlet request
    //  * @return the path
    //  */
    // // @RequestMapping(value = "/create", method = RequestMethod.POST)
    // // public final String submit(@ModelAttribute(REGISTER) @Valid final Register register, final BindingResult binding,
    // //         final HttpServletRequest request) {
    // //     final Locale locale = localeResolver.resolveLocale(request);
    // //     if (binding.hasErrors()) {
    // //         return "create";
    // //     }
    // //     final UserAccount user = new UserAccount(register.getUsername());
    // //     user.setDisplayName(register.getDisplayName());
    // //     user.setEmail(register.getEmail());
    // //     user.setPassword(passwordEncoder.encodePassword(register.getPassword(), user.getSalt()));
    // //     try {
    // //         userDetailsService.addUser(user, locale);
    // //     } catch (DuplicateUserException e) {
    // //         binding.addError(new FieldError(REGISTER, "username",
    // //                 messageSource.getMessage("create.error.username", null, locale)));
    // //         return "create";
    // //     }
    // //     return "redirect:/register/success";
    // // }

    // @GetMapping("/cusomter/retrieveCustomerForm")
    // /**
    //  * 초기 고객 조회 화면을 구성하기 위한 정보를 생성하여 반환한다. 
    //  * @param model
    //  * @return String 고객조회 html
    //  */
    // public String createRetrieveCustomerForm(Model model) {
    //     log.info("CustomerController.createRetrieveCustomerForm start ...");

    //     //List<Customer> customers = customerService.findCustoemrs();

    //     CustomerSearchDto customerSearchDto = new CustomerSearchDto();
    //     List<CustomersDto> customersDto = new ArrayList<CustomersDto>();

    //     model.addAttribute("customersSearchDto", customerSearchDto);
    //     model.addAttribute("customersDto", customersDto);

    //     return "customer/retrieveCustomer";
    // }

    // @PostMapping("/cusomter/retrieveCustomerForm")
    // /**
    //  * 조회 조건으로 고객명, 고객구분을 받아서, 리스트로 조회할 정보를 customersDto로 반환한 한다.
    //  * @param custoemrName
    //  * @param customerType
    //  * @param model
    //  * @return String 고객조회 html
    //  */
    // public String retrieveCustomerList(@RequestParam("customerName") String custoemrName,
    //         @RequestParam("customerType") String customerType, Model model) {

    //     CustomerSearchDto customerSearchDto = new CustomerSearchDto();
    //     List<CustomersDto> customersDto = customerService.retrieveCustomerList(custoemrName, customerType);

    //     model.addAttribute("customersSearchDto", customerSearchDto);
    //     model.addAttribute("customersDto", customersDto);
    //     return "customer/retrieveCustomer";
    // }
}