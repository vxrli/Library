package com.basespringboot.dto;

import java.time.LocalDate;

public record LoansResponse(
        Long id,
        Long bookId,
        String bookTitle,
        Long memberId,
        String memberName,
        LocalDate loanDate,
        LocalDate expectedReturnDate,
        LocalDate actualReturnDate,
        boolean returned
) {}