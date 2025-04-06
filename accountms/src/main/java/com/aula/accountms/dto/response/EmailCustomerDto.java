package com.aula.accountms.dto.response;

import java.util.UUID;

public record EmailCustomerDto(
        UUID userId,
        String subject,
        String text

) {
}
