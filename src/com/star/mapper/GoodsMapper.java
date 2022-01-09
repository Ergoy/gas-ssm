package com.star.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.star.entity.Goods;

@Repository("goodsMapper")
public interface GoodsMapper {
	public List<Goods> findAll();
	public Goods getGoodsById(@Param("gid") String id);
	public int updateGoods(Goods goods);
	public int addGoods(Goods goods);
	public int deleteGoods(@Param("gid") String id);

}
