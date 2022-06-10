package com.magalu.communication.service;

import com.magalu.communication.controller.ScheduleController;
import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.model.entity.Schedule;
import com.magalu.communication.repository.ScheduleRepository;
import com.magalu.communication.utils.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private ScheduleController scheduleController;
    private ScheduleMapper scheduleMapper;
    private ScheduleRepository scheduleRepository;

    public void create(ScheduleDTO scheduleDTO){

        Schedule scheduleToCreate = scheduleMapper.toModel(scheduleDTO);
        scheduleRepository.save(scheduleToCreate);
    }

}
