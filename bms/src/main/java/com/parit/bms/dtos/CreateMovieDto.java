package com.parit.bms.dtos;

import com.parit.bms.enums.Language;

import com.parit.bms.models.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateMovieDto {

    private String title;
    private List<Language> languages = new ArrayList<>();
    private Double rating;


    public Movie toMovie(){
        return Movie.builder()
                        .title(title)
                                .languages(languages)
                                        .rating(rating)
                                                .build();
    }
}
