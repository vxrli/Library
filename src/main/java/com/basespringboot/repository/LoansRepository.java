package com.basespringboot.repository;

import com.basespringboot.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    List<Loans> findByMemberId(Long memberId);

    List<Loans> findByBookId(Long bookId);

    List<Loans> findByReturned(boolean returned);

    List<Loans> findByMemberIdAndReturned(Long memberId, boolean returned);
}