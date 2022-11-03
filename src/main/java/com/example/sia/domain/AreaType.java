package com.example.sia.domain;

import lombok.Getter;

@Getter
public enum AreaType {
	INTEREAST("INTEREAST", "관심지역"),
	ADMINISTRATIVE("ADMINISTRATIVE", "행정지역");

	private final String code;
	private final String value;

	AreaType(String code, String value) {
		this.code = code;
		this.value = value;
	}

}
