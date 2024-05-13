package com.parit.bms.controllers;

import com.parit.bms.dtos.CreateScreenDto;
import com.parit.bms.models.Screen;
import com.parit.bms.services.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/screen")
@AllArgsConstructor
public class ScreenController {

    private ScreenService service;

    @PostMapping
    public Screen createService(@RequestBody CreateScreenDto createScreenDto){
        return service.createScreen(createScreenDto);
    }

    @GetMapping("{/id}")
    public Screen getService(@PathVariable Long id){
        return service.getScreen(id);
    }
}
