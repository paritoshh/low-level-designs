package com.parit.bms.repositories;

import com.parit.bms.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findAllByScreen_id(Long screenId);
}
