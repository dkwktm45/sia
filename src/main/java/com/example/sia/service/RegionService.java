package com.example.sia.service;


import com.example.sia.domain.Region;
import com.example.sia.dto.RegionDto;
import com.example.sia.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service	@Transactional
@RequiredArgsConstructor
public class RegionService {
	private final RegionRepository regionRepository;

	public String saveAndReId(RegionDto regionDto) throws com.vividsolutions.jts.io.ParseException {
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		Region region = Region.builder().uuid(uuid).name(regionDto.getName()).areaType(regionDto.getAreaType()).build();
		region.convertToArea(regionDto.getArea());
		regionRepository.InsertRegion(region.getName(),region.getAreaType().getCode(),region.getPolygon().toString());
		return uuid;
	}
}
