package com.banc.card.service;
import com.banc.card.dto.BankCardDto;
import com.banc.card.entity.Bank;
import com.banc.card.entity.BankCard;
import com.banc.card.entity.Person;
import com.banc.card.repository.BankCardRep;
import com.banc.card.repository.BankRep;
import com.banc.card.repository.PersonRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankCardService {
    private final BankRep bankRep;
    private final BankCardRep bankCardRep;
    private final PersonRep personRep;

    public BankCardService(BankRep bankRep, BankCardRep bankCardRep, PersonRep personRep) {
        this.bankRep = bankRep;
        this.bankCardRep = bankCardRep;
        this.personRep = personRep;
    }


    public BankCard createBankCard(Long bankId, Long personId, BankCardDto bankCardDto) {
        if (bankId != null && bankRep.existsById(bankId) && personId != null && personRep.existsById(personId)) {
            Bank bank = bankRep.findById(bankId).get();
            Person person = personRep.findById(personId).get();
            BankCard bankCard = new BankCard();
            bankCard.setCardNumber(bankCardDto.getCardNumber());
            bankCard.setCardExpirationDate(bankCardDto.getCardExpirationDate());
            bankCard.setCVV(bankCardDto.getCVV());
            bankCard.setTypeCard(bankCardDto.getTypeCard());
            bankCard.setIdBank(bank);
            bankCard.setPerson(person);
            return bankCardRep.save(bankCard);
        } else {
            throw new NoSuchElementException("Bank with id " + bankId + " not found");
        }
    }

    public List<BankCard> getAllBankCard() {
        return bankCardRep.findAll();
    }

}


 /*public BankCard updateBankCard(Long id,Long bankId, BankCardDto bankCardDto) {
        if (bankId != null && id != null) {
            if (bankRep.existsById(bankId) && bankCardRep.existsById(id)) {
                Bank bank = bankService.getBankById(bankId);
                BankCard bankCard = getBankCardById(id);
                bankCard.setCardNumber(bankCardDto.getCardNumber());
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

    }*/

    /*public BankCard getBankCardById(Long id) {
        try {
            if (id != null) {
                return bankCardRep.findById(id).get();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }*/

/*
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
    }*/

