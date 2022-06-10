package com.magalu.communication.controller;

import com.magalu.communication.model.dto.ScheduleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDTO create(
            @RequestBody @Valid ScheduleDTO scheduleDTO ){

        return //service;
    }
}
