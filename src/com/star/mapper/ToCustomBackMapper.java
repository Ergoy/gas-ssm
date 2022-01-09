package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.ToCustomBack;
@Repository("toCustomBackMapper")
public interface ToCustomBackMapper {
	public List<ToCustomBack> fandAll(@Param("cbdid") String cbdid);
	public ToCustomBack findById(@Param("cbdid") String cbdid);
	public int updateCustom_back(ToCustomBack tcb);
	public int insert (ToCustomBack tcb);
	public int deleteCustom_back (@Param("cbdid") String cbdid);

}
