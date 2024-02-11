package com.banc.card.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // уникальный идентификатор банка
    @Column(name = "name_bank")
    private String nameBank;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private int houseNumber;

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", nameBank='" + nameBank + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id == bank.id && houseNumber == bank.houseNumber && Objects.equals(nameBank, bank.nameBank) && Objects.equals(city, bank.city) && Objects.equals(street, bank.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameBank, city, street, houseNumber);
    }
}

