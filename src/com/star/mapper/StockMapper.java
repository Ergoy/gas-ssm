package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.Stock;

@Repository("stockMapper")

public interface StockMapper {
	public List<Stock>findAll();
	public Stock findById(@Param("sid") String sid);
	public int updateStock(Stock st);
	public int insert(Stock st);
	public int deleteStock (@Param("sid") String sid);

}
