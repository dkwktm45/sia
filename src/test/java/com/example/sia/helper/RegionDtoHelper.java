package com.example.sia.helper;

import com.example.sia.domain.AreaType;
import com.example.sia.domain.Region;
import com.example.sia.dto.RegionDto;
import com.example.sia.utils.PolygonHelper;

public class RegionDtoHelper {

	public RegionDto createRegion(String name , int size){
		PolygonHelper polygonHelper = new PolygonHelper();
		RegionDto regionDto = new RegionDto();
		regionDto.setArea(polygonHelper.createHelper(size));
		regionDto.setName(name);
		regionDto.setAreaType(AreaType.ADMINISTRATIVE);
		return regionDto;
	}
}
