package com.banc.card.repository;

import com.banc.card.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRep extends JpaRepository<CreditCard, Long> {
}
