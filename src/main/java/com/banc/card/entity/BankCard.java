package com.banc.card.entity;

import com.banc.card.converter.TypeCardConverter;
import com.banc.card.enums.TypeCard;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
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
    private long id; // уникальный идентификатор банковской карты

    @Column(name = "card_number")
    private long cardNumber; // номер банковской карты

    @Column(name = "card_expiration_date")
    private LocalDateTime cardExpirationDate; // дата истечения срока действия карты

    @Column(name = "cvv")
    private int CVV; // CVV-код карты

    @Column(name = "max_limit")
    private double maxLimit; // кредитный лимит

    @Convert(converter = TypeCardConverter.class)
    @Column(name = "type_card", length = 25)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private TypeCard typeCard; // тип карты "дебетовая", "кредитная"


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_bank", referencedColumnName = "id")  // Связь с полем id в классе Bank
    private Bank idBank; // ссылка на таблицу "Банки"

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person", referencedColumnName = "id")  // Связь с полем id в классе person
    private Person person; // ссылка на таблицу Person

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return id == bankCard.id && cardNumber == bankCard.cardNumber && CVV == bankCard.CVV && Double.compare(maxLimit, bankCard.maxLimit) == 0 && Objects.equals(cardExpirationDate, bankCard.cardExpirationDate) && typeCard == bankCard.typeCard && Objects.equals(idBank, bankCard.idBank) && Objects.equals(person, bankCard.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardExpirationDate, CVV, maxLimit, typeCard, idBank, person);
    }
}

