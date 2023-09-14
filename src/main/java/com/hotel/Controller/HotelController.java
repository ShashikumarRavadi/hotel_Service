package com.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Model.Hotel;
import com.hotel.Services.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl service;

	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAll() {
		List<Hotel> all = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getById(@PathVariable String hotelId) {
		Hotel byId = service.getById(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}
	
	@DeleteMapping("/{hotelId}")
	public String delete(@PathVariable String hotelId) {
		String deleteHotel = service.deleteHotel(hotelId);
		return deleteHotel;
	}

}