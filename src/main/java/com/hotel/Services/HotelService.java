package com.hotel.Services;

import java.util.List;

import com.hotel.Model.Hotel;

public interface HotelService {

	public Hotel create(Hotel hotel);
	
	public List<Hotel> getAll();
	
	public Hotel getById(String hotelId);
	
	public String deleteHotel(String hotelId);
	
	
}
