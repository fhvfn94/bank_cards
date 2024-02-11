package com.banc.card.controller;

import com.banc.card.dto.CreditCardDto;
import com.banc.card.entity.CreditCard;
import com.banc.card.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/credit")
public class CreditCardController {
    CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public CreditCard addCreditCard(@RequestParam Long bankId, @RequestBody CreditCardDto creditCardDto) {
        return creditCardService.createCreditCard(bankId, creditCardDto);
    }

    @PutMapping(path = "/{id}")
    public CreditCard putCreditCard(@PathVariable Long id, @RequestParam Long bankId, @RequestBody CreditCardDto creditCardDto) {
        return creditCardService.updateCreditCard(id, bankId, creditCardDto);
    }

    @GetMapping(path = "/{id}")
    public CreditCard getCreditCard(@PathVariable Long id) {
        return creditCardService.getCreditCardById(id);
    }

    @GetMapping
    public List<CreditCard> getAllCreditCard() {
        return creditCardService.getAllBankCard();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCreditCard(@PathVariable Long id) {
        try {
            creditCardService.deleteCreditCardById(id);
            return ResponseEntity.ok("delete");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}