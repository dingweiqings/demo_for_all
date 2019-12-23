package com.ding.cache.redis.service;
import java.util.List;

import com.ding.cache.redis.entity.User;
public interface UserService {
public User getUserByName(String name);
public List<User> getAllUser(String key);
public void   saveUsers(List<User>user ,String key);
} 
