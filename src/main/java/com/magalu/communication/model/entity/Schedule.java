package com.magalu.communication.model.entity;

import com.magalu.communication.utils.enums.CommunicationTypeEnum;
import com.magalu.communication.utils.enums.ScheduleStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "communication")
public class Schedule extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda", nullable = false)
    private Long scheduleId;

    @Column(name = "data_hora", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Column(name = "destinatario ", nullable = false)
    private String recipient;

    @Column(name = "mensagem ", nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comunicacao ", nullable = false)
    private CommunicationTypeEnum communicationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status ", nullable = false)
    private ScheduleStatusEnum scheduleStatus;

}
