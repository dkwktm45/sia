package com.example.sia.repository;

import com.example.sia.domain.AreaType;
import com.example.sia.domain.Region;
import com.example.sia.dto.Area;
import com.example.sia.utils.PolygonHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.vividsolutions.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class RegionRepositoryTest {
	private PolygonHelper polygonHelper = new PolygonHelper();
	@Autowired
	private RegionRepository regionRepository;

	private Logger logger = LoggerFactory.getLogger(RegionRepositoryTest.class);


	@DisplayName("행정지역의 이름, 전체 지리 정보를 저장합니다.")
	@Test
	void save() throws ParseException, com.vividsolutions.jts.io.ParseException {
		// given
		String name = "북한산";
		List<Area> areaList = polygonHelper.createHelper(3);

		// when
		Polygon polygon = polygonHelper.convertToPolygon(areaList);
		Region region = Region.builder().name(name).polygon(polygon).areaType(AreaType.ADMINISTRATIVE).build();
		regionRepository.save(region);

		// then
		Region result = regionRepository.findById(1L).get();
		Assertions.assertEquals(polygon,result.getPolygon());
	}


}