package com.example.sia.dto;

import com.example.sia.domain.AreaType;
import com.example.sia.utils.Converter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class RegionDto {

	private String uuid;
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(
			name ="area",
			joinColumns = @JoinColumn(name = "region_id")
	)
	private List<Area> area = new ArrayList<>();
	@Convert(converter = Converter.class)
	private AreaType areaType;
}
