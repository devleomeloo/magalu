package com.magalu.communication.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.magalu.communication.utils.enums.CommunicationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    @NotNull(message = "Informar a data e a hora do agendamento !")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @NotNull(message = "Informar o destinatário da notificação !")
    private String recipientName;

    @NotBlank(message = "Informar a mensagem a ser enviada ao destinatário !")
    private String message;

    private String communicationType;
}
