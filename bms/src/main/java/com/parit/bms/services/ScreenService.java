package com.parit.bms.services;

import com.parit.bms.dtos.CreateScreenDto;
import com.parit.bms.enums.SeatType;
import com.parit.bms.models.Screen;
import com.parit.bms.models.Seat;
import com.parit.bms.repositories.ScreenRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class ScreenService {
    private ScreenRepository screenRepository;
    private SeatService seatService;
    public Screen createScreen(CreateScreenDto createScreenDto) {

        Screen screen = Screen.builder()
                .name(createScreenDto.getName())
                .build();
        Screen createdScreen = screenRepository.save(screen);
        List<Seat> seats = seatService.getAllSeats(100, 10, 10, SeatType.NORMAL, createdScreen.getId());
        return screenRepository.save(createdScreen.toBuilder().seats(seats).build());
    }

    public Screen getScreen(Long id) {
        return screenRepository.findById(id).orElse(null);
    }
}
