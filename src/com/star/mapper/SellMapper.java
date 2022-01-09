package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.Goods;
import com.star.entity.Sell;

@Repository("sellMapper")

public interface SellMapper {
	public List<Sell> findAll();
	public Sell findById(@Param("sid") String sid);
	public int updateSell(Sell sell);
	public int insert(Sell sell);
	public int deleteSell(@Param("sid") String sid);
}
