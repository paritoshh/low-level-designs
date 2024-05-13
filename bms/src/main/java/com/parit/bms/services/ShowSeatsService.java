package com.parit.bms.services;

import com.parit.bms.models.ShowSeat;
import com.parit.bms.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatsService {

    private ShowSeatRepository seatRepository;

    public List<ShowSeat> saveAllShowSeats(List<ShowSeat> showSeats) {
        return seatRepository.saveAll(showSeats);
    }
}
