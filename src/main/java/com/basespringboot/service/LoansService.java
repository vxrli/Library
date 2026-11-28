package com.basespringboot.service;
 
import com.basespringboot.dto.LoansRequest;
import com.basespringboot.dto.LoansResponse;
 
import java.util.List;
 
public interface LoansService {
 
    LoansResponse createLoan(LoansRequest loansRequest);
 
    LoansResponse getLoanById(Long id);
 
    List<LoansResponse> getAllLoans();
 
    List<LoansResponse> getLoansByMember(Long memberId);
 
    List<LoansResponse> getLoansByBook(Long bookId);
 
    LoansResponse returnLoan(Long id);
 
    void deleteLoan(Long id);
}
 