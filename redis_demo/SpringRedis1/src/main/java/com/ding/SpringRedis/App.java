package com.ding.SpringRedis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ding.SpringRedis.entity.User;
import com.ding.SpringRedis.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
     UserService userService=(UserService)context.getBean("userService");
     int n=10;
     for(int i=0;i<n;i++){
         userService.getUserByName("");
        // System.out.println(i+"  "+user.getId()+"  "+ user.getName()); 
     }
  
    }
}
