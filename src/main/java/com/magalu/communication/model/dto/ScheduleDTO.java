package com.magalu.communication.model.dto;

import com.magalu.communication.utils.enums.CommunicationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    @NotNull(message = "Informar a data e a hora do agendamento !")
    private LocalDateTime dateTime;

    @NotNull(message = "Informar o destinatário da notificação !")
    private RecipientDTO recipient;

    @NotBlank(message = "Informar a mensagem a ser enviada ao destinatário !")
    private String message;

    private CommunicationTypeEnum communicationType;

}
