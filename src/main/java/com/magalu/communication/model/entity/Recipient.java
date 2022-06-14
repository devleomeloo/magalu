package com.magalu.communication.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "communication")
public class Recipient extends Auditable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_destinatario", nullable = false)
//    private Long recipientId;

    @Id
    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "telefone", nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToOne(mappedBy = "recipient", fetch = FetchType.LAZY)
    private Schedule schedule;
}
