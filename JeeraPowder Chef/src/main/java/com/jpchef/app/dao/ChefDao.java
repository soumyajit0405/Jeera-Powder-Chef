package com.jpchef.app.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
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


import com.jpchef.app.model.BookingDetail;
import com.jpchef.app.model.ChefDetail;
import com.jpchef.app.model.UserProfile;
import com.jpchef.app.util.CustomMessages;
import com.jpchef.app.util.SHAUtility;




@Transactional
@Repository
public class ChefDao extends AbstractBaseDao{

	@PersistenceContext
    private EntityManager manager;
	
	
public List<Object[]> fetchAllBookings(HashMap<String,String> chefDetails){
		
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	List<HashMap<String,Object>> listOfBookingDetails= new ArrayList<>();;
	List<Object[]> bookingData=new ArrayList<>();
		try
		{
			Query query=
					manager.createQuery("select a from BookingDetail a where a.chefDetail.chefId="+Integer.parseInt(chefDetails.get("chefId")));
			 bookingData=(List<Object[]>)query.getResultList();
			
			return bookingData;	
			
		}
	catch(NoResultException e)
	{
		
		e.printStackTrace();
		return  bookingData;
	}
		
		
	}

public HashMap<String,Object> fetchBookingDetails (HashMap<String,String> chefDetails){
	
	//Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	BookingDetail bookingDetails= null;
	HashMap<String,Object> response=new HashMap<String, Object>();
		try
		{
			Query query=
					manager.createQuery("select a.bookingId,a.baseCost,a.chefDetail.fullName from BookingDetail a where a.chefDetail.chefId="+Integer.parseInt(chefDetails.get("chefId")));
			List<Object[]> bookingData=(List<Object[]>)query.getResultList();
			
			 for(Object[] result: bookingData)
			 {
				
				 response.put("bookingId",Long.toString((Long)result[0]));
				 response.put("baseCost",(BigDecimal)result[1]);
				 response.put("chefName", (String)result[2]);
				//listOfBookingDetails.add(bk);
			 }
			return response;
		}
	catch(NoResultException e)
	{
		
		e.printStackTrace();
		return response;
	}
		
		
	}

public Hashtable<String,String> updateBookingStatus  (HashMap<String,String> bookingDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	
	
		try
		{
			Query query=manager.createQuery("update BookingDetail set bookingStatus="+bookingDetails.get("statusId"));
			query.executeUpdate();
			response.put("response", "1");
		}
	catch(NoResultException e)
	{
		
		e.printStackTrace();
		response.put("response", "-1");
	}
		return response;
		
	}


}
