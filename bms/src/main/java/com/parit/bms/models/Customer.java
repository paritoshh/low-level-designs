package com.parit.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer extends BaseModel {

    private String email;
    private String name;
    private String phoneNumber;
    private String city;
    @OneToOne
    private User user;
}
