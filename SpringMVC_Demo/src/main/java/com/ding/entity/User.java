package com.ding.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class User implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = -4405230305996667400L;
@Min(value=0,message="id.length")
@Max(value=100,message="id.length")
Integer id;
@Size(min=1,max=10,message="name.length")
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
