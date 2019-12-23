package com.ding.cache.ehcache.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ding.cache.ehcache.dao.HibernateDaoSupport;
import com.ding.cache.ehcache.dao.UserDao;
import com.ding.entity.User;
@Component
public class UserDaoImpl  extends HibernateDaoSupport implements UserDao{

	@SuppressWarnings("deprecation")
	public List<User> getAllUser(String key) {
		List<User>list=null;
		//String hql="select new User(user.id,user.name) from User user";
		String hql=" from User";
		Query<User> query=null;
		try{
	      query=	getSession().createQuery(hql);
		}catch(Exception e){
			e.printStackTrace();			
		}
		
		
		
		if(query!=null){
			list=query.list();
		}		
		System.out.println("Get data from db");	
		
		return list;
	}

	public void saveUsers(List<User> list, String key) {
		
		
	}
	
	public User getUserByName(String name) {		
		
		
		return null;
	}
	@CacheEvict(value="user",allEntries=true,beforeInvocation=true)
	public void insert(User user){
		save(user);
		
		
	}
	
	
}
