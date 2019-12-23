package com.ding.springmvc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ding.cache.ehcache.service.UserService;
import com.ding.entity.User;

@Controller
public class MainController {
	@Resource
	UserService userService;
	
	
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception{
//    实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀  	   	
    	
    	User user=new User();
    	user.setId(1);
    	user.setName("Chace");
//    	ModelAndView mav=new ModelAndView();
//    	mav.setViewName("register");
    	if(true)
    	throw new Exception("This is test exception");
        return new ModelAndView("register", "command", new User());
    }
    @RequestMapping(value = "dealRegister", method = RequestMethod.POST)
    public String dealRegister(@Validated User user, BindingResult bindingResult,ModelMap mm){
//    实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀  	  
    	boolean result=true;
    	if(bindingResult.hasErrors()){
    		FieldError idError=bindingResult.getFieldError("id");
    		FieldError nameError=bindingResult.getFieldError("name");			
    		
    		
    		
    		mm.addAttribute("idError",idError);
    		mm.addAttribute("nameError",nameError);
    		return "register";
    	}
    	userService.insert(user);
    	mm.addAttribute("id",user.getId());
    	mm.addAttribute("name", user.getName());
    	if(result)
    	return "welcome";
    	else
        return "index";
    }
    @RequestMapping(value = "welcome", method = RequestMethod.POST)
    public String welcome(){
//    实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀  	  
    	boolean result=true;
    
    //	userService.insert(user); 	
    	if(result)
    	return "welcome";
    	else
        return "index";
    }
    @RequestMapping(value = "allUsers", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){
//    实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀  	  
    	ModelAndView mav=new ModelAndView(); 
    	mav.setViewName("allUsers");
    	List<User>list =userService.getAllUser("");
    	mav.addObject("users", list);    	
        return mav;
    }
    
    
}
