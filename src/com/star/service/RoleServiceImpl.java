package com.star.service;
 
import java.util.List;
 


import javax.annotation.Resource;
 


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.star.entity.Role;
import com.star.mapper.RoleMapper;
 

 
@Service(value="roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
 
	@Resource
    public RoleMapper roleMapper;
	
	@Override
	public List<Role> findAllRole() {
		List<Role> findAllRole = roleMapper.findAllRole();
		return findAllRole;
	}
 
}