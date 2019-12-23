package com.ding.cache.ehcache.service;
import java.util.List;

import com.ding.entity.User;
public interface UserService {
public User getUserByName(String name);
public List<User> getAllUser(String key);
public void   saveUsers(List<User>user ,String key);
public void insert(User user);
} 
