//package com.star.service;
// 
//import java.util.List;
// 
//
//
//import javax.annotation.Resource;
// 
//
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.star.entity.UserA;
//import com.star.mapper.UserMapper;
//
// 
//@Service(value="userService")
//@Transactional
//public class UserServiceImpl implements UserService {
// 
//	@Resource
//    public UserMapper userMapper;
//	
//	@Override
//	public List<UserA> findAllUser() {
//		List<UserA> findAllUser = userMapper.findAllUser();
//		return findAllUser;
//	}
// 
//}