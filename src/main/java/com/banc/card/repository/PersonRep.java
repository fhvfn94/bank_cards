package com.banc.card.repository;

import com.banc.card.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRep extends JpaRepository<Person, Long> {

}
