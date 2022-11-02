package com.example.sia.service;

import com.example.sia.repository.AoiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AoisService {
	private final AoiRepository aoiRepository;
}
