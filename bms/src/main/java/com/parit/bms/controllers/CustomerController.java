package com.parit.bms.controllers;


import com.parit.bms.dtos.CreateCustomerDto;
import com.parit.bms.exceptions.InvalidCustomerCreateRequest;
import com.parit.bms.models.Customer;
import com.parit.bms.services.CustomerService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){

        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDto customer){
        validateCustomer(customer);
        return customerService.createCustomer(customer);

    }
    private void validateCustomer(CreateCustomerDto customer){
        if(StringUtils.isBlank(customer.getName()) || customer.getPassword()==null){
            throw new InvalidCustomerCreateRequest("Invalid request for create customer.");
        }
    }
}
