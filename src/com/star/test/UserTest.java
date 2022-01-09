package com.star.test;

import java.util.List;










import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.test.context.ContextConfiguration;

import com.star.entity.Provider;
import com.star.entity.Role;
import com.star.entity.User;
import com.star.mapper.ProviderMapper;
import com.star.mapper.RoleMapper;
import com.star.mapper.UserMapperR;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;





@RunWith(SpringJUnit4ClassRunner.class)//表示让SpringJUnit4ClassRunner来运行
@ContextConfiguration(locations ={"classpath:config/spring.xml"})
public class UserTest {
    @Autowired
    private RoleMapper userDao;
    @Autowired
    private ProviderMapper pm;
    @Autowired
    private UserMapperR umr;
    
    @Test
    public void test_1(){
    	System.out.println(2345);
//        List<User> list=userDao.get_List();
//        for (User user : list) {
//            System.out.println(user.getPassword());
//        }
//        User user=new User();
//        user.setUsername("xxxx");
//        userDao.insert_Info(user);
        List<Role> list=userDao.findAllRole();
        for (Role user : list) {
            System.out.println(user.getRoleName());
        }
        
    }
    
    @Test
    public void test_2(){
    	
//        List<User> list=userDao.get_List();
//        for (User user : list) {
//            System.out.println(user.getPassword());
//        }
//        User user=new User();
//        user.setUsername("xxxx");
//        userDao.insert_Info(user);
        List<Provider> list=pm.findAll();
        for (Provider user : list) {
            System.out.println(user.getTotalprice());
        }
        
    }
    
    @Test
    public void test_3(){
    	
//        List<User> list=userDao.get_List();
//        for (User user : list) {
//            System.out.println(user.getPassword());
//        }
//        User user=new User();
//        user.setUsername("xxxx");
//        userDao.insert_Info(user);
        User user=umr.login("star");
        System.out.println(user.getPwd());
        
    }
}
