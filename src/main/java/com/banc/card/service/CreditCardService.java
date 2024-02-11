package com.banc.card.service;

import com.banc.card.dto.CreditCardDto;
import com.banc.card.entity.Bank;
import com.banc.card.entity.BankCard;
import com.banc.card.entity.CreditCard;
import com.banc.card.repository.BankRep;
import com.banc.card.repository.CreditCardRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CreditCardService {
    BankService bankService;
    CreditCardRep creditCardRep;
    BankRep bankRep;

    public CreditCardService(BankService bankService, CreditCardRep creditCardRep, BankRep bankRep) {
        this.bankService = bankService;
        this.creditCardRep = creditCardRep;
        this.bankRep = bankRep;
    }

    public CreditCard createCreditCard(Long bankId, CreditCardDto creditCardDto) {
        if (bankId != null) {
            if (bankRep.existsById(bankId)) {
                Bank bank = bankService.getBankById(bankId);
                CreditCard creditCard = new CreditCard();
                creditCard.setCardNumber(creditCardDto.getCardNumber());
                creditCard.setCardExpirationDate(creditCardDto.getCardExpirationDate());
                creditCard.setIdBank(bank);
                creditCard.setCVV(creditCardDto.getCVV());
                creditCard.setTypeCard(creditCardDto.getTypeCard());
                creditCard.setMaxLimit(creditCardDto.getMaxLimit());
                creditCard.setPercentCredit(creditCard.getPercentCredit());
                return creditCardRep.save(creditCard);
            } else {
                throw new NoSuchElementException("Bank with id " + bankId + " not found");
            }
        } else {
            throw new IllegalArgumentException("Id Bank cannot be null");
        }


    }

    public CreditCard updateCreditCard(Long id, Long bankId, CreditCardDto creditCardDto) {
        if (bankId != null && id != null) {
            if (bankRep.existsById(bankId) && creditCardRep.existsById(id)) {
                Bank bank = bankService.getBankById(bankId);
                CreditCard creditCard = getCreditCardById(id);
                creditCard.setCardNumber(creditCardDto.getCardNumber());
                creditCard.setCardExpirationDate(creditCardDto.getCardExpirationDate());
                creditCard.setIdBank(bank);
                creditCard.setCVV(creditCardDto.getCVV());
                creditCard.setTypeCard(creditCardDto.getTypeCard());
                creditCard.setMaxLimit(creditCardDto.getMaxLimit());
                creditCard.setPercentCredit(creditCard.getPercentCredit());
                return creditCardRep.save(creditCard);
            } else {
                throw new NoSuchElementException("Bank with id " + bankId + " or credit card with id " + id +  " not found");
            }
        } else {
            throw new IllegalArgumentException("Id Bank and id credit card cannot be null");
        }

    }

    public CreditCard getCreditCardById(Long id) {
        try {
            if (id != null) {
                return creditCardRep.findById(id).get();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<CreditCard> getAllBankCard() {
        try {
            return creditCardRep.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deleteCreditCardById(Long id) {
        try {
            if (id != null) {
                if (creditCardRep.existsById(id)) {
                    creditCardRep.deleteById(id);
                } else {
                    throw new NoSuchElementException("Credit card with id " + id + " not found");
                }
            } else {
                throw new IllegalArgumentException("Id cannot be null");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException();
        }
    }
}

