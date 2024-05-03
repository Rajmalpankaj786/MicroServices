package com.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Entity.Hotel;
import com.hotel.Exception.ResourceNotFound;
import com.hotel.Repositary.HotelRepo;

@Service
public class HotelServiceImpl implements HotelServices {

	@Autowired
	private HotelRepo hotelRepo;
	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getById(Integer id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFound("does't found given id :"+id));
	}

	@Override
	public Hotel updateHotel(Hotel updatehotel) {
		// TODO Auto-generated method stub
		Optional<Hotel> hotel = hotelRepo.findById(updatehotel.getId());
		if(hotel.get()!=null) {
			Hotel existingHotel = hotel.get();
			existingHotel.setName(updatehotel.getName());
			existingHotel.setLocation(updatehotel.getLocation());
			existingHotel.setAbout(updatehotel.getAbout());
			return hotelRepo.save(existingHotel);
		}
		throw new ResourceNotFound("does't exist for the given id : "+updatehotel.getId());
	}

}
