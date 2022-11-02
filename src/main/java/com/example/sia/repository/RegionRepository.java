package com.example.sia.repository;

import com.example.sia.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
