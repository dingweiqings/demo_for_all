package com.ding.cache.ehcache.dao;

import java.util.List;

import com.ding.entity.User;

public interface UserDao {
public User getUserByName(String name);
public List<User> getAllUser(String key);
public void saveUsers(List<User> list,String key);
public void insert(User user);
}
