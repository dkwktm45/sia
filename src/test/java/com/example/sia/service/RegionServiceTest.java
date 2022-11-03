package com.example.sia.service;

import com.example.sia.domain.Region;
import com.example.sia.dto.RegionDto;
import com.example.sia.helper.RegionDtoHelper;
import com.example.sia.helper.RegionHelper;
import com.example.sia.repository.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.vividsolutions.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RegionServiceTest {
	@Mock
	RegionRepository regionRepository;
	@InjectMocks
	RegionService regionService;
	private RegionDtoHelper regionDtoHelper;
	private RegionHelper regionHelper;
	@BeforeEach
	void setUp(){
		this.regionDtoHelper = new RegionDtoHelper();
		this.regionHelper = new RegionHelper();
	}

	@DisplayName("해당 지리 정보를 저장한다.")
	@Test
	void test1() throws ParseException, com.vividsolutions.jts.io.ParseException {
		//given
		String name = "북구청";
		RegionDto regionDto = regionDtoHelper.createRegion(name,3);
		Region region = regionHelper.createRegion(regionDto);
		//when
		Mockito.when(regionRepository.save(region)).thenReturn(null);

		// then
		RegionService regionService = new RegionService(regionRepository);
		regionService.saveAndReId(regionDto);
		verify(regionRepository).save(
				refEq(region));
	}
}