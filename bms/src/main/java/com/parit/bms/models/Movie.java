package com.parit.bms.models;

import com.parit.bms.enums.Genre;
import com.parit.bms.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie extends BaseModel{

    private String title;
    @Enumerated
    private Genre genre;
    private Double rating;

    @Enumerated
    @ElementCollection
    private List<Language> languages = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
