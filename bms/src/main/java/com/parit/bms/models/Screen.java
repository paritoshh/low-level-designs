package com.parit.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.BindParam;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder(toBuilder = true)
public class Screen extends BaseModel {

    private String name;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();
}
