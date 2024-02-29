package com.banc.card.service;

import com.banc.card.dto.BankDto;
import com.banc.card.entity.Bank;
import com.banc.card.repository.BankRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankService {
    private final BankRep bankRep;
    @Autowired
    public BankService(BankRep bankRep) {
        this.bankRep = bankRep;
    }

    public Bank createBank(BankDto bankDto) {
        Bank bank = new Bank();
        bank.setNameBank(bankDto.getNameBank());
        bank.setCity(bankDto.getCity());
        bank.setStreet(bankDto.getStreet());
        bank.setHouseNumber(bankDto.getHouseNumber());
        return bankRep.save(bank);
    }

    public Bank updateBank(Long id, BankDto bankDto) {
        try {
            Bank bank = getBankById(id);
            bank.setNameBank(bankDto.getNameBank());
            bank.setCity(bankDto.getCity());
            bank.setStreet(bankDto.getStreet());
            bank.setHouseNumber(bankDto.getHouseNumber());
            return bankRep.save(bank);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Bank getBankById(Long id) {
        try {
            if (id != null) {
                return bankRep.findById(id).get();
            } else {
                throw new RuntimeException();
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Bank> getAllBank() {
        try {
            return bankRep.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public void deleteBankById(Long id) {
        if (id != null) {
            if (bankRep.existsById(id)) {
                bankRep.deleteById(id);
            } else {
                throw new NoSuchElementException("Bank with id " + id + " not found");
            }
        } else {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
