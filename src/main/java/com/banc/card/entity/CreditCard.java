package com.banc.card.entity;


import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_card_id")
    private long id; // уникальный идентификатор банковской карты
    @Column(name = "card_number")
    private long cardNumber; // номер банковской карты
    @Column(name = "card_expiration_date")
    private Date cardExpirationDate; // дата истечения срока действия карты
    @Column(name = "cvv")
    private int CVV; // CVV-код карты
    @Column(name = "type_card")
    private String typeCard; // тип карты "дебетовая", "кредитная"
    @Column(name = "max_limit")
    private double maxLimit; // кредитный лимит
    @Column(name = "percent_credit")
    private double percentCredit; //процентная ставка
    @ManyToOne
    @JoinColumn(name = "id_Bank")  // Связь с полем id в классе Bank
    private Bank idBank; // ссылка на таблицу "Банки"

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardExpirationDate=" + cardExpirationDate +
                ", CVV=" + CVV +
                ", typeCard='" + typeCard + '\'' +
                ", maxLimit=" + maxLimit +
                ", percentCredit=" + percentCredit +
                ", idBank=" + idBank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return id == that.id && cardNumber == that.cardNumber && CVV == that.CVV && Double.compare(maxLimit, that.maxLimit) == 0 && Double.compare(percentCredit, that.percentCredit) == 0 && Objects.equals(cardExpirationDate, that.cardExpirationDate) && Objects.equals(typeCard, that.typeCard) && Objects.equals(idBank, that.idBank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardExpirationDate, CVV, typeCard, maxLimit, percentCredit, idBank);
    }
}

