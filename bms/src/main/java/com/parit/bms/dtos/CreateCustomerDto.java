package com.parit.bms.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parit.bms.models.Customer;
import lombok.Data;

@Data
public class CreateCustomerDto {

    private String name;
    private String email;
    @JsonProperty("ph")
    private String phoneNumber;
    private String city;
    private String username;
    private String password;

}
