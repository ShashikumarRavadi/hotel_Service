package com.hotel.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.Model.Hotel;

public interface HotelRepo extends MongoRepository<Hotel, String>{

}
