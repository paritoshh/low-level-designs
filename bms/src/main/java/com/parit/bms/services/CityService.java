package com.parit.bms.services;

import com.parit.bms.dtos.CreateCityDto;
import com.parit.bms.models.City;
import com.parit.bms.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public City addCity(CreateCityDto createCityDto) {
        return cityRepository.save(City.builder().name(createCityDto.getName()).build());
    }

    public City getCity(Long id){
        return cityRepository.findById(id).orElse(null);
    }
}
