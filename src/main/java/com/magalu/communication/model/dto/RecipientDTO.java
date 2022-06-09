package com.magalu.communication.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDTO {

    private String name;
    private String phone;
    private String email;
}
