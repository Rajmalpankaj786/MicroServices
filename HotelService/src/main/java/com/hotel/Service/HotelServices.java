package com.hotel.Service;

import java.util.List;

import com.hotel.Entity.Hotel;

public interface HotelServices {

	List<Hotel> getAll();
	Hotel addHotel(Hotel hotel);
	Hotel getById(Integer id);
	Hotel updateHotel(Hotel hotel);
}
