package com.parit.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Theater extends BaseModel{

    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String address;
    @OneToMany
    private List<Screen> screens = new ArrayList<>();
    @OneToMany
    private List<Movie> movies =new ArrayList<>();
    @OneToMany
    private List<Show> shows = new ArrayList<>();

}
