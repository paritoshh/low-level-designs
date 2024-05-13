package com.parit.bms.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCityDto {

    private String name;
}
