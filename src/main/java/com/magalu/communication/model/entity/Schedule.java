package com.magalu.communication.model.entity;

import com.magalu.communication.model.dto.RecipientDTO;
import com.magalu.communication.utils.enums.CommunicationTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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

    @OneToOne(cascade = {CascadeType.MERGE})
    private Recipient recipient;

    @Column(name = "mensagem ", nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comunicacao ", nullable = false)
    private CommunicationTypeEnum communicationType;
}
