package com.jazzyshi.springmybatis.mapper;

import java.util.List;

import com.jazzyshi.springmybatis.pojo.Airport;
import org.apache.ibatis.annotations.Select;


public interface AirportMapper {
	@Select("select * from t_user")
	List<Airport> selAll();
}
