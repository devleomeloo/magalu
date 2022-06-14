package com.magalu.communication.service;

import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.model.entity.Schedule;
import com.magalu.communication.repository.ScheduleRepository;
import com.magalu.communication.utils.mapper.ScheduleMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    private static final ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    @Test
    void whenNewScheduleIsInformedThenShouldBeCreated() {
        //arrange
        ScheduleDTO expectedScheduleToCreate =
                ScheduleDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .recipientName(null)
                        .message("test")
                        .communicationType("SMS")
                        .build();
        Schedule expectedCreatedSchedule = scheduleMapper.toModel(expectedScheduleToCreate);

        //act
        when(scheduleRepository.save(any())).thenReturn(expectedCreatedSchedule);
        ScheduleDTO createdScheduleDTO = scheduleService.create(expectedScheduleToCreate);

        //assert
        assertEquals(createdScheduleDTO, expectedScheduleToCreate);
    }
}
