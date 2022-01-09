package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.ToCustom;
@Repository("toCustomMapper")

public interface ToCustomMapper {
	public List<ToCustom> findAll();
	public ToCustom findById(@Param("cbid") String cbid);
	public int updateCustom(ToCustom tc);
	public int insert (ToCustom tc);
	public int deleteCustom(@Param("cbid") String cbid);

}
