package com.parit.bms.models;


import com.parit.bms.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking extends BaseModel{

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats = new ArrayList<>();
    private Double amount;
    private Date bookedAt;
    @Enumerated
    private BookingStatus bookingStatus;
    @OneToMany
    private List<Payment> payments = new ArrayList<>();

}
