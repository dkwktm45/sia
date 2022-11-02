package com.example.sia.controller;

import com.example.sia.domain.Region;
import com.example.sia.service.AoisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping("/aois")
public class AoisController {

	private final AoisService aoisService;

	/*
	 * 관심 지역의 이름, 전체 지리 정보를 저장합니다.
	 * */
	@GetMapping(value = {"/",""})
	public ResponseEntity<Long> getAoisId(@RequestBody Region region){
		return null;
	}

}
