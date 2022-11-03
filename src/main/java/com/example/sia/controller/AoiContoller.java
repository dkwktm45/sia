package com.example.sia.controller;

import com.example.sia.dto.RegionDto;
import com.example.sia.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping("/aois")
public class AoiContoller {
	private final RegionService regionService;

	/*
	 * 행정지역의 이름, 전체 지리 정보를 저장합니다
	 * */
	@PostMapping(path ={"/",""} )
	public ResponseEntity<String> saveRegion(@RequestBody RegionDto regionDto) throws com.vividsolutions.jts.io.ParseException {
		return ResponseEntity.ok(regionService.saveAndReId(regionDto));
	}
}
