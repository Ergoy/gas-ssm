package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.GoodsType;

@Repository("goodsTypeMapper")
public interface GoodsTypeMapper {
	public List<GoodsType> findAll();
	public GoodsType getGoodsTypeById(@Param("tid") String tid);
	public int updateGoodsType(GoodsType goodsType);
	public int addGoodsType(GoodsType goodsType);
	public int deleteGoodsType(@Param("tid") String tid);

}
