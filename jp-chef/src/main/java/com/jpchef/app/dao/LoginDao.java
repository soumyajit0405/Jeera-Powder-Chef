package com.jpchef.app.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.jpchef.app.model.ChefDetail;
import com.jpchef.app.model.ChefEarning;
import com.jpchef.app.model.ChefPayout;
import com.jpchef.app.model.UserProfile;
import com.jpchef.app.util.CustomMessages;
import com.jpchef.app.util.SHAUtility;




@Transactional
@Repository
public class LoginDao extends AbstractBaseDao{

	@PersistenceContext
    private EntityManager manager;
	
	
public Hashtable<String,String> loginUser(HashMap<String,String> loginDetails){
		
	Hashtable<String,String> response=new Hashtable<>();
	Long regId=(long) 0;
	ChefDetail chefdetail = null;
		try
		{
			byte[] salt=SHAUtility.getSalt();
			String password=SHAUtility.get_SHA_1_SecurePassword(loginDetails.get("password"),salt);
			
			Query query = manager.
				      //createQuery("Select a from ChefDetail  a where a.chefId='"+loginDetails.get("userName")+"' and a.password='"+password+"'");
					createQuery("Select a from ChefDetail  a where a.chefId="+loginDetails.get("chefId"));
			 chefdetail=(ChefDetail)query.getSingleResult();
					regId = (Long)chefdetail.getChefId();
			if(regId==0)
			{				response.put("response", CustomMessages.getCustomMessages("IVC"));
							response.put("loginStatus", "3");

			}
			else
			{
				
				//ChefDto chefdto=new 
				response.put("name", chefdetail.getFullName());
				response.put("chefId", Long.toString(chefdetail.getChefId()));
				response.put("loginStatus", "1");
			//	response.put("regId", Integer.toString(regId));
				//Send Response 
			}

		}
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("response", CustomMessages.getCustomMessages("ISE"));
		response.put("key", "500"); 
		return response; 
	}
		return response;
		
	}


public ChefDetail getChefDetails(HashMap<String,String> chefDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	ChefDetail chefdetail = null;
		try
		{
			
			Query query = manager.
				      createQuery("Select a from ChefDetail  a where a.chefId='"+chefDetails.get("chefId")+"'");
			 chefdetail=(ChefDetail)query.getSingleResult();
				return chefdetail;
						}
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("response", CustomMessages.getCustomMessages("ISE"));
		response.put("key", "500"); 
		return chefdetail; 
	}
		
		
	}

public List<ChefPayout> fetchAccountDetails(HashMap<String,String> chefDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	List<ChefPayout> listOfChefPayouts = null;
		try
		{
			
			listOfChefPayouts =manager.createQuery("Select a from ChefPayout  a where a.chefId='"+chefDetails.get("chefId")+"'",ChefPayout.class).getResultList();
			
				return listOfChefPayouts;
						}
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("response", CustomMessages.getCustomMessages("ISE"));
		response.put("key", "500"); 
		return listOfChefPayouts; 
	}
		
		
	}

public List<ChefEarning> fetchEarnings(HashMap<String,String> chefDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	List<ChefEarning> listOfChefEarnings = null;
		try
		{
			
			listOfChefEarnings =manager.createQuery("Select a from ChefEarning  a where a.chefId='"+chefDetails.get("chefId")+"'",ChefEarning.class).getResultList();
			
				return listOfChefEarnings;
						}
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("response", CustomMessages.getCustomMessages("ISE"));
		response.put("key", "500"); 
		return listOfChefEarnings; 
	}
		
		
	}

public String testConnection(){
	
	System.out.println("1 ===Java JDBC PostgreSQL Example");
	try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JP", "hrpanelpgfinal", "BAtOAGykVrezOMNB")) {
		 
        System.out.println("Java JDBC PostgreSQL Example");
        // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
        // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//      Class.forName("org.postgresql.Driver"); 

        System.out.println("Connected to PostgreSQL database!");
        return "1";
	}
      catch (SQLException e) {
        System.out.println("Connection failure.");
        e.printStackTrace();
        return "0";
    }
      
      catch (Exception e) {
          System.out.println("Connection failure.");
          e.printStackTrace();
          return "0";
      }
}	
		
	}


