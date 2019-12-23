package com.ding.cache.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ding.SpringRedis.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext context=new FileSystemXmlApplicationContext(""
     		+ "src/main/java/com/ding/cache/redis/"
     		+ "applicationContext.xml");
     UserService userService=(UserService)context.getBean("userService");
     int n=10;
     for(int i=0;i<n;i++){
         userService.getUserByName("");
        // System.out.println(i+"  "+user.getId()+"  "+ user.getName()); 
     }
  
    }
}
