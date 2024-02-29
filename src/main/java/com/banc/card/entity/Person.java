package com.banc.card.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // уникальный идентификатор пользователя

    @Column(name = "first_name")
    private String firstName; // имя пользователя

    @Column(name = "last_name")
    private String lastName; // фамилия пользователя

    @Column(name = "email")
    private String email; // адрес электронной почты пользователя

    @Column(name = "password")
    private String password; // пароль пользователя

    @Column(name = "birth")
    private Date birth; // дата рождения пользоватетеля

    @Column(name = "date_registration")
    private Date dateRegistration; // дата регистрации пользователя

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "flat_number")
    private int flatNumber;

    @OneToMany(mappedBy = "person")
    private Set<BankCard> bankCard; // банковская карта

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && houseNumber == person.houseNumber && flatNumber == person.flatNumber && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(password, person.password) && Objects.equals(birth, person.birth) && Objects.equals(dateRegistration, person.dateRegistration) && Objects.equals(city, person.city) && Objects.equals(street, person.street) && Objects.equals(bankCard, person.bankCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, birth, dateRegistration, city, street, houseNumber, flatNumber, bankCard);
    }
}

