package com.hotel.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Exceptions.ResourceNotFoundException;
import com.hotel.Model.Hotel;
import com.hotel.Repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo repo;

	@Override
	public Hotel create(Hotel hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return repo.findAll();
	}

	@Override
	public Hotel getById(String hotelId) {
		return repo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel not found with given id "+hotelId));
	}

	@Override
	public String deleteHotel(String hotelId) {
	 if(repo.findById(hotelId).isPresent()) {
		repo.deleteById(hotelId);
		return "Hotel deleted with Id: "+hotelId;
	 }else {
		 return "Hotel not found with ID "+hotelId +" to delete it.";
	 }
	}
}
