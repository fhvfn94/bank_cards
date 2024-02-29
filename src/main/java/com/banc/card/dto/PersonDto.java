package com.banc.card.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class PersonDto {
    private String firstName; // имя пользователя
    private String lastName; // фамилия пользователя
    private String email; // адрес электронной почты пользователя
    private String password; // пароль пользователя
    private Date birth; // дата рождения пользоватетеля
    private Date dateRegistration; // дата регистрации пользователя
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;
}
