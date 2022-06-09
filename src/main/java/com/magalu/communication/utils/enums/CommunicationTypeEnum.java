package com.magalu.communication.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommunicationTypeEnum {

    EMAIL("email"),
    SMS("sms"),
    PUSH("push"),
    WHATSAPP("whatsapp");

    private final String type;
}
