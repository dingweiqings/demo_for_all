package com.ding.SpringRedis.service.impl;

import org.springframework.cache.annotation.Cacheable;

import com.ding.SpringRedis.dao.UserDao;
import com.ding.SpringRedis.entity.User;
import com.ding.SpringRedis.service.UserService;


public class UserServiceImpl implements UserService{

	UserDao userDao;
	@Cacheable("users")
	public User getUserByName(String name) {
		User usera=userDao.getUserByName(name);		
		User userb=userDao.getUserByName(name);	
		
		return userb;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
