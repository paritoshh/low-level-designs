package com.parit.bms.models;


import com.parit.bms.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Seat extends BaseModel{
    private Integer rowNo;
    private Integer colNo;
    @Enumerated
    private SeatType seatType;
    @ManyToOne()
    @JoinColumn(name = "screen_id")
    private Screen screen;

}
