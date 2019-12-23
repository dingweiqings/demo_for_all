package com.ding.pac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {  
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
    	  StoreData stdata = (StoreData) context.getBean("storeData");
    	
        //creating configuration object  
   
      stdata.StoreData();

    } 

}
