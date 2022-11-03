package com.example.sia.helper;

import com.example.sia.domain.Region;
import com.example.sia.dto.RegionDto;
import com.example.sia.utils.PolygonHelper;
import com.vividsolutions.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;

public class RegionHelper {
	private PolygonHelper polygonHelper = new PolygonHelper();
	public Region createRegion(RegionDto regionDto) throws ParseException, com.vividsolutions.jts.io.ParseException {
		Polygon polygon = polygonHelper.convertToPolygon(regionDto.getArea());
		return Region.builder().name(regionDto.getName()).polygon(polygon).areaType(regionDto.getAreaType()).build();
	}
}
