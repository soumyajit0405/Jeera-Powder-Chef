package com.jpchef.app.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	
	
public List<BookingDetail> fetchAllBookings(HashMap<String,String> chefDetails){
		
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	List<BookingDetail> listOfBookingDetails= null;
	
		try
		{
			listOfBookingDetails=
					manager.createQuery("select a from BookingDetail a where a.chefId="+Integer.parseInt(chefDetails.get("chefId")),BookingDetail.class).getResultList();
			return listOfBookingDetails;
		}
	catch(NoResultException e)
	{
		
		e.printStackTrace();
		return listOfBookingDetails;
	}
		
		
	}

public BookingDetail fetchBookingDetails (HashMap<String,String> chefDetails){
	
	Hashtable<String,String> response=new Hashtable<>();
	int regId=0;
	BookingDetail bookingDetails= null;
	
		try
		{
			bookingDetails=
					manager.createQuery("select a from BookingDetail a where a.chefId="+Integer.parseInt(chefDetails.get("chefId"))+" and a.bookingId="+Integer.parseInt(chefDetails.get("bookingId")),BookingDetail.class).getSingleResult();
			return bookingDetails;
		}
	catch(NoResultException e)
	{
		
		e.printStackTrace();
		return bookingDetails;
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
