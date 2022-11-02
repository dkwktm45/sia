package com.example.sia.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Data
@Entity
public class Aoi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(
			name ="area",
			joinColumns = @JoinColumn(name = "aoi_id")
	)
	private Set<Area> area = new HashSet<>();
}
