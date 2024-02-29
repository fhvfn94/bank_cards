package com.banc.card.service;

import com.banc.card.dto.PersonDto;
import com.banc.card.entity.Person;
import com.banc.card.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRep personRep;

    @Autowired
    public PersonService(PersonRep personRep) {
        this.personRep = personRep;
    }


    public Person createPerson(PersonDto personDto) {
        Person person = new Person();
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
    }

    public Person updatePerson(Long id, PersonDto personDto) {
        if (id != null && personRep.existsById(id)) {
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
        } else {
            throw new RuntimeException(id + " did not fined");
        }

    }

    public Person getPersonById(Long id) {
        if (id != null && personRep.existsById(id)) {
            return personRep.findById(id).get();
        } else {
            throw new RuntimeException(id + " did not fined");
        }
    }

    public List<Person> getAllPerson() {
        return personRep.findAll();
    }

    public void deletePersonById(Long id) {
        if (id != null && personRep.existsById(id)) {
            personRep.deleteById(id);
        } else {
            throw new RuntimeException(id + " did not fined");
        }
    }
}
