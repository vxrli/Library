package com.basespringboot.repository;

import com.basespringboot.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface MembersRepository extends JpaRepository<Members, Long> {
    
}
