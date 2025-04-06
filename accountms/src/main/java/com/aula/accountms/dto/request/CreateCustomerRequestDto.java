package com.aula.accountms.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequestDto(
        @NotNull
        @NotEmpty
        String name,
        @NotNull
        @NotEmpty
        String email,
        @NotNull
        @NotEmpty
        String mobileNumber,
		String password
) {
}
