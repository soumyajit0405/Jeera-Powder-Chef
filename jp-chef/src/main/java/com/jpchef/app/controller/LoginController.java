package com.jpchef.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpchef.app.model.ChefDetail;
import com.jpchef.app.services.LoginService;





@RestController
public class LoginController extends AbstractBaseController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = REST+"loginUser", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,String> loginUser(@RequestBody HashMap<String,String> loginDetails){
	//	System.out.println(loginDetails.get("userName"));
		return loginService.loginUser(loginDetails);
		
	}
	
	@RequestMapping(value = REST+"getChefDetails", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,ChefDetail> getChefDetails(@RequestBody HashMap<String,String> chefDetails){
		
		Hashtable<String,ChefDetail> response=new Hashtable<>();
		 response.put("response",loginService.getChefDetails(chefDetails));
		return response;
	}
	
	
	@RequestMapping(value = REST+"testService", method = RequestMethod.GET)
	public String testService(){
		return loginService.testConnection();
		
	}
	
		
}
