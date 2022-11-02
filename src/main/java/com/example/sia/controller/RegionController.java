package com.example.sia.controller;

import com.example.sia.domain.Region;
import com.example.sia.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping("regions")
public class RegionController {

	private final RegionService regionService;

	/*
	* 행정지역의 이름, 전체 지리 정보를 저장합니다
	* */
	@PostMapping(value = {"/",""})
	public ResponseEntity<Long> saveRegion(@RequestBody Region region){
		return null;
	}
	/*
	 * 행정지역에 지리적으로 포함되는 관심지역을 조회합니다.
	 * */
	@GetMapping(value = "/{region-id}/aois/intersects")
	public ResponseEntity<Long> getRegion(@RequestBody Region region){
		return null;
	}
}
