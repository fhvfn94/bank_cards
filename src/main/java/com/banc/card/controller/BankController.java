package com.banc.card.controller;

import com.banc.card.dto.BankDto;
import com.banc.card.entity.Bank;
import com.banc.card.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/bank")
public class BankController {
    BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    @PostMapping
    public Bank addBank(@RequestBody BankDto bankDto) {
        return bankService.createBank(bankDto);
    }

    @PutMapping(path = "/{id}")
    public Bank putBank(@PathVariable Long id, @RequestBody BankDto bankDto) {
        return bankService.updateBank(id, bankDto);
    }

    @GetMapping(path = "/{id}")
    public Bank getBank(@PathVariable Long id) {
        return bankService.getBankById(id);
    }

    @GetMapping
    public List<Bank> getAllBank() {
        return bankService.getAllBank();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBank(@PathVariable Long id) {
        try {
            bankService.deleteBankById(id);
            return ResponseEntity.ok("delete");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

