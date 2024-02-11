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
@Table(name = "bank_card")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_card_id")
    private long id; // уникальный идентификатор банковской карты
    @Column(name = "card_number")
    private long cardNumber; // номер банковской карты
    @Column(name = "card_expiration_date")
    private Date cardExpirationDate; // дата истечения срока действия карты
    @Column(name = "cvv")
    private int CVV; // CVV-код карты
    @Column(name = "type_card")
    private String typeCard; // тип карты "дебетовая", "кредитная"
    @ManyToOne
    @JoinColumn(name = "id_bank")  // Связь с полем id в классе Bank
    private Bank idBank; // ссылка на таблицу "Банки"

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardExpirationDate=" + cardExpirationDate +
                ", CVV=" + CVV +
                ", typeCard='" + typeCard + '\'' +
                ", idBank=" + idBank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return id == bankCard.id && cardNumber == bankCard.cardNumber && CVV == bankCard.CVV && Objects.equals(cardExpirationDate, bankCard.cardExpirationDate) && Objects.equals(typeCard, bankCard.typeCard) && Objects.equals(idBank, bankCard.idBank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardExpirationDate, CVV, typeCard, idBank);
    }
}

