package com.parit.bms.services;

import com.parit.bms.dtos.CreateCustomerDto;
import com.parit.bms.exceptions.CustomerAlreadyExists;
import com.parit.bms.exceptions.CustomerNotFoundException;
import com.parit.bms.models.Customer;
import com.parit.bms.models.User;
import com.parit.bms.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with id: "+id+" not found."));
    }

    public Customer createCustomer(CreateCustomerDto createCustomerDto){
        if(customerRepository.findByEmail(createCustomerDto.getEmail()).isPresent()){
            throw new CustomerAlreadyExists("Customer already exists, :"+createCustomerDto.getEmail());
        }

        //create user
        User user = userService.createUser(createCustomerDto.getUsername(), createCustomerDto.getPassword());
        Customer newCustomer = Customer.builder()
                .email(createCustomerDto.getEmail())
                .name(createCustomerDto.getName())
                .city(createCustomerDto.getCity())
                .phoneNumber(createCustomerDto.getPhoneNumber())
                .user(user)
                .build();
        return customerRepository.save(newCustomer);
    }
}
