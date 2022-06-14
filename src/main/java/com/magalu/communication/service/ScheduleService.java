package com.magalu.communication.service;

import com.magalu.communication.controller.ScheduleController;
import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.model.entity.Schedule;
import com.magalu.communication.repository.ScheduleRepository;
import com.magalu.communication.utils.enums.ScheduleStatusEnum;
import com.magalu.communication.utils.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private static final ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleDTO create(ScheduleDTO scheduleDTO){

        Schedule scheduleToCreate = scheduleMapper.toModel(scheduleDTO);
        scheduleToCreate.setScheduleStatus(ScheduleStatusEnum.PENDENTE);
        return  scheduleMapper.toDTO(scheduleRepository.save(scheduleToCreate));
    }

    public List<Schedule> getAll(){
        return scheduleRepository.findAll();
    }

}
