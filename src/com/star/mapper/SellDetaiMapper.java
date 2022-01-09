package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.SellDetail;
@Repository("sellDetaiMapper")
public interface SellDetaiMapper {
	public List<SellDetail> findAll(@Param("sdid") String sdid);
	public SellDetail findById (@Param("sdid") String sdid);
	public int updateSellDetail(SellDetail sd);
	public int insert (SellDetail sd);
	public int deleteSellDetail(@Param("sdid") String sdid);
}
