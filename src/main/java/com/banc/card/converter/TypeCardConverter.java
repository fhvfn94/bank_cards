package com.banc.card.converter;

import com.banc.card.enums.TypeCard;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TypeCardConverter implements AttributeConverter<TypeCard, String> {
    @Override
    public String convertToDatabaseColumn(TypeCard typeCard) {
        return (typeCard != null) ? typeCard.name() : null;
    }

    @Override
    public TypeCard convertToEntityAttribute(String s) {
        return TypeCard.valueOf(s);
    }
}
