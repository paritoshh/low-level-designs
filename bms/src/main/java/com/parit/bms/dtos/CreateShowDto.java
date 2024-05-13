package com.parit.bms.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CreateShowDto {

    @NotNull(message = "movieId is mandatory.")
    private Long movieId;
    private Long theaterId;
    private Long screenId;
    private Date dateTime;

}
