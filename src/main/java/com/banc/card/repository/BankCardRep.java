package com.banc.card.repository;

import com.banc.card.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRep extends JpaRepository<BankCard, Long> {
}
