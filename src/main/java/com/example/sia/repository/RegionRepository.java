package com.example.sia.repository;

import com.example.sia.domain.AreaType;
import com.example.sia.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface RegionRepository extends JpaRepository<Region,Long> {

	@Modifying
	@Query(value = "insert into region (name ,polygon,area_type,uuid) values (" +
			":name, ST_GeomFromText(:polygon), :area_type, :uuid)",nativeQuery = true)
	void InsertRegion(@Param("name") String name,
	                  @Param("area_type") String area_type,
	                  @Param("polygon") String area,
	                  @Param("uuid") String uuid);

	@Query(value = "insert into region (name ,polygon,area_type,uuid) values (" +
			":name, ST_GeomFromText(:polygon), :area_type, :uuid)",nativeQuery = true)
	Set<Region> findByUuidAndAreaType(String uuid, String areaType);
}
