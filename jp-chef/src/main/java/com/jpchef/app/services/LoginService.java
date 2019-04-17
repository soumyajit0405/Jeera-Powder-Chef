package com.jpchef.app.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jpchef.app.dao.LoginDao;
import com.jpchef.app.model.ChefDetail;





@Service("loginService")
public class LoginService extends AbstractBaseService{

	@Autowired
	private LoginDao loginDao;
	
	public Hashtable<String,String> loginUser(HashMap<String,String> loginDetails){
		
		return loginDao.loginUser(loginDetails);
	}
	public ChefDetail getChefDetails(HashMap<String,String> chefDetails){
		return loginDao.getChefDetails( chefDetails);
	}
	public String testConnection(){
		return loginDao.testConnection();
	}
}
