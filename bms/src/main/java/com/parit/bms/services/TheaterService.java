package com.parit.bms.services;


import com.parit.bms.dtos.CreateTheaterRequestDto;
import com.parit.bms.models.City;
import com.parit.bms.models.Theater;
import com.parit.bms.repositories.TheaterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheaterService {

    private CityService cityService;
    private TheaterRepository theaterRepository;

    public Theater createTheater(CreateTheaterRequestDto createTheaterRequestDto){

        //validate city
        City city = cityService.getCity(createTheaterRequestDto.getCityId());
        if(city == null){
            throw new RuntimeException("City not found for id " + createTheaterRequestDto.getCityId());
        }

        Theater theater = Theater
                .builder()
                .city(city)
                .address(createTheaterRequestDto.getTheaterAddress())
                .name(createTheaterRequestDto.getTheaterName())
                .build();

        return theaterRepository.save(theater);
    }
}
