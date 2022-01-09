package com.star.mapper;
 
import java.util.List;
 

import org.springframework.stereotype.Repository;

import com.star.entity.Role;
 

@Repository
public interface RoleMapper {
	
	List<Role> findAllRole();
}