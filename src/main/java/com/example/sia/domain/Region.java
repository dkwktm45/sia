package com.example.sia.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Data
@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(
			name ="area",
			joinColumns = @JoinColumn(name = "region_id")
	)
	private Set<Area> area = new HashSet<>();
}
