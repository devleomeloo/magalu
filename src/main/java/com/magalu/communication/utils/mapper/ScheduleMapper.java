package com.magalu.communication.utils.mapper;

import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.model.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    Schedule toModel(ScheduleDTO scheduleDTO);

    ScheduleDTO toDTO(Schedule schedule);
}
