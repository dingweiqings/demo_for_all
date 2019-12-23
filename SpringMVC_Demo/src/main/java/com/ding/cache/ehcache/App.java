package com.ding.cache.ehcache;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ding.cache.ehcache.service.UserService;
import com.ding.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext context=new FileSystemXmlApplicationContext(""
     		+ "src/main/java/com/ding/cache/ehcache/"
     		+ "applicationContext.xml");
     UserService userService=(UserService)context.getBean("userService");
     int n=5;
     for(int i=0;i<n;i++){
         userService.getUserByName("");
        // System.out.println(i+"  "+user.getId()+"  "+ user.getName()); 
     }
     
     for(int i=0;i<n;i++){
         User user=new User();
         user.setName("Knight"+i);
         //userService.insert(user);
         List<User> list=userService.getAllUser("");
         for(User j:list){
        	 System.out.println(j.getId()+j.getName());
        	 
         }
         List<User> lista=userService.getAllUser("");
         for(User j:lista){
        	 System.out.println(j.getId()+j.getName());
        	 
         }   
     }     
     
     
     
    }
}
