package com.magalu.communication.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ScheduleStatusEnum {
    ENVIADO("enviado"),
    PENDENTE("pendente");

    private final String status;
}
