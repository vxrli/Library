package com.basespringboot.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LoansRequest(
        @NotNull(message = "The book id is required") Long bookId,
        @NotNull(message = "The member id is required") Long memberId,
        @NotNull(message = "The loan date is required") LocalDate loanDate,
        @NotNull(message = "The expected return date is required") LocalDate expectedReturnDate
) {}