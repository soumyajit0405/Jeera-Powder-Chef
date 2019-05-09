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

import org.postgresql.geometric.PGpoint;
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
	
	
public Hashtable<String,Object> loginUser(HashMap<String,String> loginDetails){
		
	Hashtable<String,Object> response=new Hashtable<>();
	Long regId=(long) 0;
	long count =0;
	ChefDetail chefdetail = new ChefDetail();
		try
		{
			long checkExistence=checkExistence(Long.parseLong(loginDetails.get("chefId")));
			if(checkExistence==0)
			{
				response.put("responseStatus", "301");
				response.put("responseMessage", "Chef Not Registered");
				return response;
			}
			else
			{
				Query query=manager.createQuery("select count(*) from ChefLoginDetail a where a.chefId="+Long.parseLong(loginDetails.get("chefId")) +" and a.chefPassword='"+loginDetails.get("password")+"'");
				count=(long)query.getSingleResult();
				
				if(count == 0)
				{
					response.put("responseStatus", "300");
					response.put("responseMessage", "Invalid Credentials");
					return response;
				}
				else
				{
					  query = manager.createQuery("Select a.availabilityFlag,a.chefImage,a.comments,a.fullName,a.phoneNumber,a.qualification,a.specialization,a.chefCategory,a.chefType from ChefDetail  a where a.chefId="+loginDetails.get("chefId")); 
					 List<Object[]> chefData=(List<Object[]>)query.getResultList();
							  
							 for(Object[] result: chefData) { 
								 if(result[0] != null)
								 {
									 chefdetail.setAvailabilityFlag((boolean)result[0]);
								 }
								  if(result[1]!=null)
								 {
									 chefdetail.setChefImage((String)result[1]);
								 }
						/*
						 * else if(result[2]!=null) { chefdetail.setChefLocation((PGpoint)result[2]); }
						 */
								  if(result[2]!=null)
								 {
									 chefdetail.setComments((String)result[2]);
								 }
								  if(result[3]!=null)
								 {
									 chefdetail.setFullName((String)result[3]);
								 }
								  if(result[4]!=null)
								 {
									 chefdetail.setPhoneNumber((String)result[4]);
								 }
								  if(result[5]!=null)
								 {
									 chefdetail.setQualification((String)result[5]);
								 }
								  if(result[6]!=null)
								 {
									 chefdetail.setSpecialization((String)result[6]);
								 }
								 if(result[7]!=null)
									 {
										 chefdetail.setChefCategory((Integer)result[7]);
									 }
								 if(result[8]!=null)
									 {
										 chefdetail.setChefType((Integer)result[8]);
									 }
								 
								 chefdetail.setChefId(Long.parseLong(loginDetails.get("chefId")));
								 response.put("chefDetail", chefdetail);
									response.put("responseStatus", "200");
									response.put("responseMessage", "Login Successfull");
							  } 
				}
			}
		}
			
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("responseStatus", "500");
		response.put("responseMessage", "Internal Server Error");
		return response; 
	}
	//	return response;
		return response; 
	}


public Hashtable<String,Object> getChefDetails(HashMap<String,String> chefDetails){
	
	Hashtable<String,Object> response=new Hashtable<>();
	Long regId=(long) 0;
	long count =0;
	ChefDetail chefdetail = new ChefDetail();
		try
		{
			long checkExistence=checkExistence(Long.parseLong(chefDetails.get("chefId")));
			if(checkExistence==0)
			{
				response.put("responseStatus", "301");
				response.put("responseMessage", "Chef Not Registered");
				return response;
			}
			else
			{
					Query  query = manager.createQuery("Select a.availabilityFlag,a.chefImage,a.comments,a.fullName,a.phoneNumber,a.qualification,a.specialization,a.chefCategory,a.chefType from ChefDetail  a where a.chefId="+chefDetails.get("chefId")); 
					 List<Object[]> chefData=(List<Object[]>)query.getResultList();
							  
							 for(Object[] result: chefData) { 
								 if(result[0] != null)
								 {
									 chefdetail.setAvailabilityFlag((boolean)result[0]);
								 }
								  if(result[1]!=null)
								 {
									 chefdetail.setChefImage((String)result[1]);
								 }
						/*
						 * else if(result[2]!=null) { chefdetail.setChefLocation((PGpoint)result[2]); }
						 */
								  if(result[2]!=null)
								 {
									 chefdetail.setComments((String)result[2]);
								 }
								  if(result[3]!=null)
								 {
									 chefdetail.setFullName((String)result[3]);
								 }
								  if(result[4]!=null)
								 {
									 chefdetail.setPhoneNumber((String)result[4]);
								 }
								  if(result[5]!=null)
								 {
									 chefdetail.setQualification((String)result[5]);
								 }
								  if(result[6]!=null)
								 {
									 chefdetail.setSpecialization((String)result[6]);
								 }
								 if(result[7]!=null)
									 {
										 chefdetail.setChefCategory((Integer)result[7]);
									 }
								 if(result[8]!=null)
									 {
										 chefdetail.setChefType((Integer)result[8]);
									 }
								 
								 chefdetail.setChefId(Long.parseLong(chefDetails.get("chefId")));
								 response.put("chefDetail", chefdetail);
								 response.put("responseStatus", "200");
									response.put("responseMessage", "Details Retrived");
									
							  } 
				
			}
		}
			
	catch(Exception e)
	{
		System.out.println("Error in checkExistence"+e.getMessage());
		e.printStackTrace();
		response.put("responseStatus", "500");
		response.put("responseMessage", "Internal Server Error");
		
		return response; 
	}
	//	return response;
		return response; 
		
	}

public List<ChefPayout> fetchAccountDetails(HashMap<String,String> chefDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	List<ChefPayout> listOfChefPayouts = null;
		try
		{
			
			listOfChefPayouts =manager.createQuery("Select a from ChefPayout  a where a.chefDetail.chefId='"+chefDetails.get("chefId")+"'",ChefPayout.class).getResultList();
			
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
			
			listOfChefEarnings =manager.createQuery("Select a from ChefEarning  a where a.chefDetail.chefId='"+chefDetails.get("chefId")+"'",ChefEarning.class).getResultList();
			
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

public long checkExistence(Long chefId)
{
	long existenceStatus=0;
	try
	{
	Query query=manager.createQuery("select a.chefId from ChefLoginDetail a where a.chefId="+chefId);
	existenceStatus=(long)query.getSingleResult();
	}
	catch(Exception e)
	{
	
		return 0;
	}
	return existenceStatus;
}
		
	}


