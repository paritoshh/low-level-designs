package com.parit.bms.models;

import com.parit.bms.enums.PaymentMethod;
import com.parit.bms.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment extends BaseModel{

    @Enumerated
    private PaymentMethod paymentMethod;
    @Enumerated
    private PaymentStatus paymentStatus;
}
