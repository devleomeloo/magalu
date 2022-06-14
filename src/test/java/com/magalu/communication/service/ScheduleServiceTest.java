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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

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
                        .recipient("Magalu")
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

    @Test
    void whenGETMethodIsCalledThenAllAppointmentsShouldBeReturned() {
        //arrange
        ScheduleDTO expectedScheduleToCreate =
                ScheduleDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .recipient("Magalu")
                        .message("test")
                        .communicationType("SMS")
                        .build();
        Schedule expectedCreatedSchedule = scheduleMapper.toModel(expectedScheduleToCreate);

        //act
        when(scheduleRepository.findAll()).thenReturn(Collections.singletonList(expectedCreatedSchedule));
        List<Schedule> foundedSchedule = scheduleRepository.findAll();

        //assert
        assertThat(expectedCreatedSchedule, is(equalTo(foundedSchedule.get(0))));
    }

    @Test
    void whenValidScheduleIdIsGivenThenItShouldBeDeleted() {
        //Arrange
        ScheduleDTO expectedScheduleDeletedDTO = ScheduleDTO.builder()
                .dateTime(LocalDateTime.now())
                .recipient("Magalu")
                .message("test")
                .communicationType("SMS")
                .build();
        Schedule expectedScheduleToDeleted = scheduleMapper.toModel(expectedScheduleDeletedDTO);

        //Act
        when(scheduleRepository.findById(1L)).thenReturn(Optional.of(expectedScheduleToDeleted));
        doNothing().when(scheduleRepository).deleteById(1L);
        scheduleService.delete(1L);

        //Assert
        verify(scheduleRepository, times(1)).deleteById(1L);
    }
}
