package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.StockDetail;
@Repository("stockDetailMapper")
public interface StockDetailMapper {
	public List<StockDetail> findAll(@Param("sdid") String sdid);
	public StockDetail findById(@Param("sdid") String sdid);
	public int updateStockDetail(StockDetail sd);
	public int insert(StockDetail sd);
	public int deleteStockDetail(@Param("sdid") String sdid);

}
