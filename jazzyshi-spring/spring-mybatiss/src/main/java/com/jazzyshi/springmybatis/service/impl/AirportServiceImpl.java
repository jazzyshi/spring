package com.jazzyshi.springmybatis.service.impl;

import com.jazzyshi.springmybatis.mapper.AirportMapper;
import com.jazzyshi.springmybatis.pojo.Airport;
import com.jazzyshi.springmybatis.service.AirportService;

import java.util.List;


public class AirportServiceImpl implements AirportService {

	private AirportMapper airportMapper;

	public AirportMapper getAirportMapper() {
		return airportMapper;
	}

	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}

	@Override
	public List<Airport> show() {
		return airportMapper.selAll();
	}
}
