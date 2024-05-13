package com.parit.bms.services;

import com.parit.bms.dtos.CreateShowDto;
import com.parit.bms.enums.SeatStatus;
import com.parit.bms.exceptions.MovieNotFoundException;
import com.parit.bms.models.*;
import com.parit.bms.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowService {

    private ShowRepository showRepository;
    private MovieService movieService;
    private ScreenService screenService;
    private SeatService seatService;
    private ShowSeatsService showSeatsService;


    public Show createShow(CreateShowDto createShowDto) {

        //validate hall
        Screen screen = screenService.getScreen(createShowDto.getScreenId());
        if(screen == null){
            throw new MovieNotFoundException("Screen not found with id " + createShowDto.getScreenId());
        }

        //validate movie
        Movie movie = movieService.getMovie(createShowDto.getMovieId());
        if(movie == null){
            throw new MovieNotFoundException("Movie not found with id " + createShowDto.getMovieId());
        }

        Show show = Show.builder()
                .dateTime(createShowDto.getDateTime())
                .movie(movie)
                .screen(screen)
                .build();

        //create show seats.

        List<Seat> seatList = seatService.getAllSeatsByScreen(screen.getId());

        //Seat to ShowSeat
        List<ShowSeat> showSeats = seatList.stream().map(s-> ShowSeat.builder().seat(s).show(show).seatStatus(SeatStatus.AVAILABLE).build()).toList();
        List<ShowSeat> savedShowSeats = showSeatsService.saveAllShowSeats(showSeats);
        show.toBuilder().showSeatList(savedShowSeats);
        //create show
        return showRepository.save(show);
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElse(null);
    }
}
