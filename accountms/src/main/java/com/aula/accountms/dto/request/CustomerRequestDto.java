package com.aula.accountms.dto.request;

public record CustomerRequestDto(
        String nome,
        String email,
        String mobileNumber
) {
}
