package com.magalu.communication.controller;

import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(
            @RequestBody @Valid ScheduleDTO scheduleDTO ){

        scheduleService.create(scheduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Agendamento feito com sucesso !");
    }
}
