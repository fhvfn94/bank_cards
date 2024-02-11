package com.banc.card.service;

import com.banc.card.dto.PersonDto;
import com.banc.card.entity.BankCard;
import com.banc.card.entity.CreditCard;
import com.banc.card.entity.Person;
import com.banc.card.repository.BankCardRep;
import com.banc.card.repository.CreditCardRep;
import com.banc.card.repository.PersonRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    PersonRep personRep;
    BankCardRep bankCardRep;
    BankCardService bankCardService;
    CreditCardRep creditCardRep;
    CreditCardService creditCardService;

    public PersonService(
            PersonRep personRep,
            BankCardRep bankCardRep,
            BankCardService bankCardService,
            CreditCardRep creditCardRep,
            CreditCardService creditCardService
    ) {
        this.personRep = personRep;
        this.bankCardRep = bankCardRep;
        this.bankCardService = bankCardService;
        this.creditCardRep = creditCardRep;
        this.creditCardService = creditCardService;
    }

    public Person createPerson(List<Long> bankCardId, List<Long> creditCardId, PersonDto personDto) {
        Person person = new Person();
        List<BankCard> bankCards = bankCardRep.findAllById(bankCardId);
        List<CreditCard> creditCards = creditCardRep.findAllById(creditCardId);
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        person.setBirth(personDto.getBirth());
        person.setDateRegistration(personDto.getDateRegistration());
        person.setCity(personDto.getCity());
        person.setStreet(personDto.getStreet());
        person.setHouseNumber(personDto.getHouseNumber());
        person.setFlatNumber(personDto.getFlatNumber());
        person.setBankCard(bankCards);
        person.setCreditCard(creditCards);
        return personRep.save(person);
    }

public Person updatePerson(Long id, PersonDto personDto) {
    try {
        Person person = getPersonById(id);
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        person.setBirth(personDto.getBirth());
        person.setDateRegistration(personDto.getDateRegistration());
        person.setCity(personDto.getCity());
        person.setStreet(personDto.getStreet());
        person.setHouseNumber(personDto.getHouseNumber());
        person.setFlatNumber(personDto.getFlatNumber());
        return personRep.save(person);
    } catch (Exception e) {
        throw new RuntimeException();
    }

}

public Person getPersonById(Long id) {
    try {
        if (id != null) {
            return personRep.findById(id).get();
        } else {
            throw new RuntimeException();
        }

    } catch (Exception e) {
        throw new RuntimeException();
    }
}

public List<Person> getAllPerson() {
    try {
        return personRep.findAll();
    } catch (Exception e) {
        throw new RuntimeException();
    }
}

public void deletePersonById(Long id) {
    try {
        if (id != null) {
            personRep.deleteById(id);
        } else {
            throw new RuntimeException();
        }

    } catch (Exception e) {
        throw new RuntimeException();
    }
}
}
