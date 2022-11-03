package com.example.sia.utils;

import com.example.sia.dto.Area;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.util.ArrayList;
import java.util.List;

public class PolygonHelper {
	private final List<Area> areas = new ArrayList<>();

	public List<Area> createHelper(int size){
		Area area = new Area();
		double x;
		double y;
		double random = ((Math.random() * (100 - 10)) + 10);
		for(int i=0; i<size; i++){
			x = random;
			y = random;
			area.setX(x);
			area.setY(y);
			areas.add(i,area);
		}
		return areas;
	}
	public Polygon convertToPolygon(List<Area> areaList) throws org.locationtech.jts.io.ParseException, ParseException {
		String pointString = "POLYGON ((";
		for(int i=0; i<areaList.size(); i++){
			pointString = pointString
					.concat(Double.toString(areaList.get(i).getX())+" ").
					concat(Double.toString(areaList.get(i).getY())+",");
			if(i == areaList.size() -1){
				pointString = pointString.concat(Double.toString(areaList.get(0).getX()) + " ")
						.concat(Double.toString(areaList.get(0).getY()));
			}
		}
		pointString = pointString +"))";
		Polygon polygon = (Polygon) new WKTReader().read(pointString);
		return polygon;
	}
}
