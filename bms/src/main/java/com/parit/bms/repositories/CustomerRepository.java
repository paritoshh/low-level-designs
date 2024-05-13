package com.parit.bms.repositories;

import com.parit.bms.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    Optional<Customer> findByEmail(String email);


}
