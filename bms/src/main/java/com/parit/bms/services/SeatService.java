package com.parit.bms.services;

import com.parit.bms.enums.SeatType;
import com.parit.bms.models.Screen;
import com.parit.bms.models.Seat;
import com.parit.bms.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;
    private ScreenService screenService;

    public Seat createSeat(Seat seat) {

        return seatRepository.save(seat);
    }

    public List<Seat> createAllSeats(int n, int r, int c, SeatType seatType, Long screenId) {

        Screen screen = screenService.getScreen(screenId);
        List<Seat> screens = new ArrayList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                Seat s = Seat.builder()
                        .seatType(SeatType.NORMAL)
                        .rowNo(i)
                        .colNo(j)
                        .screen(screen)
                        .build();

                screens.add(s);
            }
        }
        return seatRepository.saveAll(screens);
    }

    List<Seat> getAllSeatsByScreen(Long screenId){
        return seatRepository.findAllByScreen_id(screenId);
    }
}
