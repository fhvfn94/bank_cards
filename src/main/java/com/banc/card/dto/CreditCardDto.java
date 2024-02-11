package com.banc.card.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;

@Data
@AllArgsConstructor
public class CreditCardDto {
    private long cardNumber; // номер банковской карты
    private Date cardExpirationDate; // дата истечения срока действия карты
    private int CVV; // CVV-код карты
    private String typeCard; // тип карты "дебетовая", "кредитная"
    private double maxLimit; // кредитный лимит
    private double percentCredit; //процентная ставка
}

