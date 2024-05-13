package com.parit.bms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateTheaterRequestDto {

    private String theaterName;
    private String theaterAddress;
    private Long cityId;
}
