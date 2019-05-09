package com.jpchef.app.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jpchef.app.dao.ChefDao;
import com.jpchef.app.dao.LoginDao;
import com.jpchef.app.model.BookingDetail;
import com.jpchef.app.model.ChefDetail;
import com.jpchef.app.model.ChefEarning;
import com.jpchef.app.model.ChefPayout;





@Service("chefService")
public class ChefService extends AbstractBaseService{

	@Autowired
	private ChefDao chefdao;
	
	public List<Object[]> fetchAllBookings(HashMap<String,String> chefDetails){
		
		return chefdao.fetchAllBookings(chefDetails);
	}
	public HashMap<String,Object> fetchBookingDetails (HashMap<String,String> chefDetails){
		return chefdao.fetchBookingDetails( chefDetails);
	}
	
	public Hashtable<String,String> updateBookingStatus  (HashMap<String,String> bookingDetails){
		return chefdao.updateBookingStatus(bookingDetails);
	}
	
}
