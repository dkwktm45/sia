package com.example.sia.utils;

import com.example.sia.domain.AreaType;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class Converter implements AttributeConverter<AreaType, String> {

	@Override
	public String convertToDatabaseColumn(AreaType attribute) {
		return attribute.getCode();
	}

	@Override
	public AreaType convertToEntityAttribute(String dbData) {
		return EnumSet.allOf(AreaType.class).stream()
				.filter(e->e.getCode().equals(dbData))
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}
}
