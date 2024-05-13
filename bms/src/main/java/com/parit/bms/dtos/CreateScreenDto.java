package com.parit.bms.dtos;

import lombok.Data;

@Data
public class CreateScreenDto {

    private String name;
    private int numberOfSeats;
    private Long theaterId;
}
