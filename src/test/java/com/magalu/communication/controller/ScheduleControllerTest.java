package com.magalu.communication.controller;

import com.magalu.communication.model.dto.ScheduleDTO;
import com.magalu.communication.service.ScheduleService;
import com.magalu.communication.utils.JsonConversionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ScheduleControllerTest {
    private static final String SCHEDULE_API_URL_PATH = "/api/v1/schedules";

    @Mock
    private ScheduleService scheduleService;

    @InjectMocks
    private ScheduleController scheduleController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {

        ScheduleDTO expectedCreatedScheduleDTO =
                ScheduleDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .recipient("Magalu")
                        .message("test")
                        .communicationType("SMS")
                .build();

        mockMvc.perform(post(SCHEDULE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConversionUtils.asJsonString(expectedCreatedScheduleDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenGETIsCalledThenStatusOkShouldBeReturned() throws Exception {

        mockMvc.perform(get(SCHEDULE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenDELETEIsCalledThenStatusOkShouldBeReturned() throws Exception {

        mockMvc.perform(delete(SCHEDULE_API_URL_PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
