package com.aula.accountms.dto.response;

import java.util.UUID;

public record CustomerResponseDto (
    UUID id,
    String email,
    String nome
) {}
