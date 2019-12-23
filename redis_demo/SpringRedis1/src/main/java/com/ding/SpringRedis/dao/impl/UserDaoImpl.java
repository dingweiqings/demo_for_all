package com.ding.SpringRedis.dao.impl;

import com.ding.SpringRedis.dao.UserDao;
import com.ding.SpringRedis.entity.User;

public class UserDaoImpl implements UserDao{

	public User getUserByName(String name) {
		User user=new User();
		user.setId(1);
		user.setName("Kurt");
		System.out.println("Get object from db");
		
		return user;
	}

}
