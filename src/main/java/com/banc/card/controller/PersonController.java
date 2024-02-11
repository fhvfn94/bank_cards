package com.banc.card.controller;


import com.banc.card.dto.PersonDto;
import com.banc.card.entity.Person;
import com.banc.card.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(
            @RequestParam List<Long> bankCardId,
            @RequestParam List<Long> creditCardId,
            @RequestBody PersonDto personDto
    ) {
        return personService.createPerson(bankCardId, creditCardId,personDto);
    }

    @PutMapping(path = "/{id}")
    public Person putPerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
        return personService.updatePerson(id, personDto);
    }

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @DeleteMapping(path = "/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "delete";
    }
}

