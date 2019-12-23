package com.ding.cache.redis.dao;

import java.util.List;

import com.ding.cache.redis.entity.User;

public interface UserDao {
public User getUserByName(String name);
public List<User> getAllUser(String key);
public void saveUsers(List<User> list,String key);
}
