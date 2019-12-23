package com.ding.cache.redis.dao.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ding.cache.redis.dao.AbstractBaseRedisDao;
import com.ding.cache.redis.dao.UserDao;
import com.ding.cache.redis.entity.User;
@Component
public class UserDaoImpl extends AbstractBaseRedisDao<String,User>  implements UserDao{

	public User getUserByName(String name) {
	//	从Redis数据库存取
	User user=redisTemplate.opsForValue().get("user1");
	if(user==null){
	
		redisTemplate.opsForValue().set("user1", new User(1,"Kurt"));
		System.out.println("Set data to db");
		user=redisTemplate.opsForValue().get("user1");
		System.out.println("Get data from db");
	}
	redisTemplate.delete("user1");
		return user;
	}
	
	public List<User> getAllUser(String key){
		
		List<User>  list=null;
		if (redisTemplate.hasKey(key)){
			Long size=redisTemplate.opsForList().size(key);
			list=redisTemplate.opsForList().range(key, 0,size );	
			System.out.print("Get data from db");
		}
		
		return list;
		
	}
	public void saveUsers(List<User> list,String key){
		   for(User user:list)
	       redisTemplate.opsForList().leftPush(key, user);	
	}
}
