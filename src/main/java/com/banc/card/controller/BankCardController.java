package com.banc.card.controller;


import com.banc.card.dto.BankCardDto;
import com.banc.card.entity.BankCard;
import com.banc.card.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/debet")
public class BankCardController {
    private final BankCardService bankCardService;

    @Autowired
    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }


    @PostMapping(path = "/{bankId}/{personId}")
    public BankCard addBankCard(@PathVariable(name = "bankId") Long bankId, @PathVariable(name = "personId") Long personId, @RequestBody BankCardDto bankCardDto) {
        return bankCardService.createBankCard(bankId,personId, bankCardDto);
    }

    /*@PutMapping(path = "/{id}")
    public BankCard putBankCard(
            @PathVariable Long id,
            @RequestParam Long bankId,
            @RequestParam Long personId,
            @RequestBody BankCardDto bankCardDto
    ) {
        return bankCardService.updateBankCard(id, bankId, bankCardDto);
    }

    @GetMapping(path = "/{id}")
    public BankCard getBankCard(@PathVariable Long id) {
        return bankCardService.getBankCardById(id);
    }*/

    @GetMapping
    public List<BankCard> getAllBankCard() {
        return bankCardService.getAllBankCard();
    }

    /*@DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBankCard(@PathVariable Long id) {
        try {
            bankCardService.deleteBankCardById(id);
            return ResponseEntity.ok("delete");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }*/
}

