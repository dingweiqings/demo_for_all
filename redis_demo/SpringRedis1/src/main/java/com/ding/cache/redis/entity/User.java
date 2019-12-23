package com.ding.cache.redis.entity;

import java.io.Serializable;

public class User implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = -4405230305996667400L;
Integer id;
String name;
public User(){
	
}
public User(int id, String name) {
	this.id=id;
	this.name=name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
