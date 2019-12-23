package com.ding.cache.redis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ding.cache.redis.dao.UserDao;
import com.ding.cache.redis.entity.User;
import com.ding.cache.redis.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{
    @Resource
	UserDao userDao;
	//@Cacheable("users")
	public User getUserByName(String name) {
		//User usera=userDao.getUserByName(name);		
		User userb=userDao.getUserByName(name);	
		
		return userb;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Cacheable("user")
	public List<User> getAllUser(String key) {
		User user=new User(3,"Kurt");
		return userDao.getAllUser(key);
	}
	public void saveUsers(List<User> user, String key) {
	
		userDao.saveUsers(user, key);
	}

}
