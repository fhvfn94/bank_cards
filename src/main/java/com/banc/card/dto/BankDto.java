package com.banc.card.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDto {
    private String nameBank;
    private String city;
    private String street;
    private int houseNumber;
}
