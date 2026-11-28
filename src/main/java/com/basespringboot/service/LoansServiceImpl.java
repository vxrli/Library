package com.basespringboot.service;

import com.basespringboot.dto.LoansRequest;
import com.basespringboot.dto.LoansResponse;
import com.basespringboot.entity.Books;
import com.basespringboot.entity.Loans;
import com.basespringboot.entity.Members;
import com.basespringboot.repository.BooksRepository;
import com.basespringboot.repository.LoansRepository;
import com.basespringboot.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) 
public class LoansServiceImpl implements LoansService {

    private final LoansRepository loansRepository;
    private final BooksRepository booksRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional
    public LoansResponse createLoan(LoansRequest request) {
        Books book = booksRepository.findById(request.bookId())
                .orElseThrow(() -> notFound("Book", request.bookId()));
        Members member = membersRepository.findById(request.memberId())
                .orElseThrow(() -> notFound("Member", request.memberId()));

        if (book.getStock() <= 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book out of stock: " + book.getTitle());
        }

        Loans loan = new Loans();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(request.loanDate());
        loan.setExpectedReturnDate(request.expectedReturnDate());

        book.setStock(book.getStock() - 1);

        return toResponse(loansRepository.save(loan));
    }

    @Override
    public LoansResponse getLoanById(Long id) {
        return toResponse(findLoan(id));
    }

    @Override
    public List<LoansResponse> getAllLoans() {
        return toResponses(loansRepository.findAll());
    }

    @Override
    public List<LoansResponse> getLoansByMember(Long memberId) {
        return toResponses(loansRepository.findByMemberId(memberId));
    }

    @Override
    public List<LoansResponse> getLoansByBook(Long bookId) {
        return toResponses(loansRepository.findByBookId(bookId));
    }

    @Override
    @Transactional
    public LoansResponse returnLoan(Long id) {
        Loans loan = findLoan(id);

        if (loan.isReturned()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Loan already returned");
        }

        loan.setReturned(true);
        loan.setActualReturnDate(LocalDate.now());

        Books book = loan.getBook();
        book.setStock(book.getStock() + 1);

        return toResponse(loan);
    }

    @Override
    @Transactional
    public void deleteLoan(Long id) {
        Loans loan = findLoan(id);

        if (!loan.isReturned()) {
            Books book = loan.getBook();
            book.setStock(book.getStock() + 1);
        }

        loansRepository.delete(loan);
    }

    private Loans findLoan(Long id) {
        return loansRepository.findById(id).orElseThrow(() -> notFound("Loan", id));
    }

    private static ResponseStatusException notFound(String entity, Long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, entity + " not found with id: " + id);
    }

    private List<LoansResponse> toResponses(List<Loans> loans) {
        return loans.stream().map(this::toResponse).toList();
    }

    private LoansResponse toResponse(Loans loan) {
        return new LoansResponse(
                loan.getId(),
                loan.getBook().getId(),
                loan.getBook().getTitle(),
                loan.getMember().getId(),
                loan.getMember().getName() + " " + loan.getMember().getFirstName(),
                loan.getLoanDate(),
                loan.getExpectedReturnDate(),
                loan.getActualReturnDate(),
                loan.isReturned()
        );
    }
}