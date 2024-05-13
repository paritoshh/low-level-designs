package com.parit.bms.controllers;


import com.parit.bms.dtos.CreateShowDto;
import com.parit.bms.models.Show;
import com.parit.bms.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private ShowService service;

    @PostMapping
    public Show createShow(@RequestBody CreateShowDto createShowDto){

        return service.createShow(createShowDto);

        //hall id
        //movie -id
        //start time


    }

    @GetMapping("{/id}")
    public Show getShowById(@PathVariable Long id){
        service.getShow(id);
    }
}
