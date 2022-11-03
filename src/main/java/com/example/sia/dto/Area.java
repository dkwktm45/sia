package com.example.sia.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter @Setter
public class Area {
	private Double x;
	private Double y;

}
