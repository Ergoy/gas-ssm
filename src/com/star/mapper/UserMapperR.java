package com.star.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.User;
@Repository("userMapperR")
public interface UserMapperR {
	public User login(@Param("name") String name);
}
