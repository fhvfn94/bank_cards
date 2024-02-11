package com.banc.card.repository;



import com.banc.card.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRep extends JpaRepository<Bank, Long> {
}

