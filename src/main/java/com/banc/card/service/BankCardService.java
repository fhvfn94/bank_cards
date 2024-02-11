package com.banc.card.service;


import com.banc.card.dto.BankCardDto;
import com.banc.card.entity.Bank;
import com.banc.card.entity.BankCard;
import com.banc.card.repository.BankCardRep;
import com.banc.card.repository.BankRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankCardService {
    BankService bankService;
    BankRep bankRep;
    BankCardRep bankCardRep;

    public BankCardService(BankService bankService, BankRep bankRep, BankCardRep bankCardRep) {
        this.bankService = bankService;
        this.bankRep = bankRep;
        this.bankCardRep = bankCardRep;
    }

    public BankCard createBankCard(Long bankId, BankCardDto bankCardDto) {
        if (bankId != null) {
            if (bankRep.existsById(bankId)) {
                Bank bank = bankService.getBankById(bankId);
                BankCard bankCard = new BankCard();
                bankCard.setCardNumber(bankCardDto.getCardNumber());
                bankCard.setCardExpirationDate(bankCardDto.getCardExpirationDate());
                bankCard.setCVV(bankCardDto.getCVV());
                bankCard.setIdBank(bank);
                bankCard.setTypeCard(bankCardDto.getTypeCard());
                return bankCardRep.save(bankCard);
            } else {
                throw new NoSuchElementException("Bank with id " + bankId + " not found");
            }
        } else {
            throw new IllegalArgumentException("Id Bank cannot be null");
        }
    }

    public BankCard updateBankCard(Long id,Long bankId, BankCardDto bankCardDto) {
        if (bankId != null && id != null) {
            if (bankRep.existsById(bankId) && bankCardRep.existsById(id)) {
                Bank bank = bankService.getBankById(bankId);
                BankCard bankCard = getBankCardById(id);
                bankCard.setCardNumber(bankCardDto.getCardNumber());
                bankCard.setCardExpirationDate(bankCardDto.getCardExpirationDate());
                bankCard.setCVV(bankCardDto.getCVV());
                bankCard.setIdBank(bank);
                bankCard.setTypeCard(bankCardDto.getTypeCard());
                return bankCardRep.save(bankCard);
            } else {
                throw new NoSuchElementException("Bank with id " + bankId + " or Bank card with id " + id +  " not found");
            }
        } else {
            throw new IllegalArgumentException("Bank card Id or Bank cannot be null");
        }

    }

    public BankCard getBankCardById(Long id) {
        try {
            if (id != null) {
                return bankCardRep.findById(id).get();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<BankCard> getAllBankCard() {
        try {
            return bankCardRep.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deleteBankCardById(Long id) {
        try {
            if (id != null) {
                if (bankCardRep.existsById(id)) {
                    bankCardRep.deleteById(id);
                } else {
                    throw new NoSuchElementException("Bank card with id " + id + " not found");
                }
            } else {
                throw new IllegalArgumentException("Id cannot be null");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException();
        }
    }

}

