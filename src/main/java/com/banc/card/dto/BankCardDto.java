package com.banc.card.dto;


import com.banc.card.entity.Bank;
import com.banc.card.entity.Person;
import com.banc.card.enums.TypeCard;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class BankCardDto {
    private long cardNumber; // номер банковской карты
    private LocalDateTime cardExpirationDate; // дата истечения срока действия карты
    private int CVV; // CVV-код карты
    private double maxLimit; // кредитный лимит
    private TypeCard typeCard; // тип карты "дебетовая", "кредитная"
    private Bank idBank; // ссылка на таблицу "Банки"
    private Person person; // ссылка на таблицу Person
}
