package com.parit.bms.models;

import com.parit.bms.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShowSeat extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated
    private SeatStatus seatStatus;
}
