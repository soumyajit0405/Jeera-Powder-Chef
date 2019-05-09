package com.jpchef.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpchef.app.model.BookingDetail;
import com.jpchef.app.model.ChefDetail;
import com.jpchef.app.model.ChefEarning;
import com.jpchef.app.model.ChefPayout;
import com.jpchef.app.services.ChefService;
import com.jpchef.app.services.LoginService;





@CrossOrigin
@RestController
public class ChefController extends AbstractBaseController{

	@Autowired
	private ChefService chefservice;
	
	@RequestMapping(value = REST+"fetchAllBookings", method = RequestMethod.POST,headers="Accept=application/json")
	public List<Object[]> fetchAllBookings(@RequestBody HashMap<String,String> chefDetails){
	//	System.out.println(loginDetails.get("userName"));
		return chefservice.fetchAllBookings(chefDetails);
		
	}
	
	
	@RequestMapping(value = REST+"fetchBookingDetails", method = RequestMethod.POST,headers="Accept=application/json")
	public HashMap<String,Object> fetchBookingDetails(@RequestBody HashMap<String,String> chefDetails){
	//	System.out.println(loginDetails.get("userName"));
		return chefservice.fetchBookingDetails(chefDetails);
		
	}
	
	@RequestMapping(value = REST+"updateBookingStatus", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,String> updateBookingStatus(@RequestBody HashMap<String,String> chefDetails){
		
		
		 return chefservice.updateBookingStatus(chefDetails);
		
	}
			
}
