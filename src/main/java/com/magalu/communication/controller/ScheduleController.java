package com.magalu.communication.controller;

import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.model.entity.Schedule;
import com.magalu.communication.model.response.MessageResponse;
import com.magalu.communication.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<MessageResponse> create(
            @RequestBody @Valid ScheduleDTO scheduleDTO ){

        scheduleService.create(scheduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Agendamento feito com sucesso !"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Schedule> getAll(){
        return scheduleService.getAll();
    }

    @DeleteMapping("{scheduleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MessageResponse> delete(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);

        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Agendamento deletado com sucesso !"));
    }
}
