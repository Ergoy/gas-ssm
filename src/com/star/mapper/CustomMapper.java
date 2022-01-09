package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.star.entity.Custom;

public interface CustomMapper {
	public List<Custom> selectCustomByType(Integer type);
	public Custom selectCustomById(@Param("cid")String id);
	public List<Custom> selectAllCustom();
	public int addCustom(Custom custom);
	public int updateCustom(Custom custom);
	public int deleteCustom(@Param("cid")String id);
}
