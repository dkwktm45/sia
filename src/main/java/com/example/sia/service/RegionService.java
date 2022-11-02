package com.example.sia.service;


import com.example.sia.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionService {
	private final RegionRepository regionRepository;
}
