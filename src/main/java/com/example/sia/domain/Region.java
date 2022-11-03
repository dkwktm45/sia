package com.example.sia.domain;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.example.sia.dto.Area;
import com.example.sia.utils.Converter;
import com.example.sia.utils.PolygonHelper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Polygon;
import lombok.*;
import org.wololo.jts2geojson.GeoJSONReader;

import javax.persistence.*;
import java.util.List;

@Getter @Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Builder
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String uuid;
	@Convert(converter = Converter.class)
	private AreaType areaType;

	@Column(name="polygon", columnDefinition = "geometry(Polygon,4326)")
	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(contentUsing = GeometryDeserializer.class)
	private Polygon polygon;

	@SneakyThrows
	public void convertToArea(List<Area> areas) throws com.vividsolutions.jts.io.ParseException {
		PolygonHelper polygonHelper = new PolygonHelper();
		this.polygon = polygonHelper.convertToPolygon(areas);
	}
}
