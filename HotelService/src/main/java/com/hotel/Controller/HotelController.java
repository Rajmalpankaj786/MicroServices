package com.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Entity.Hotel;
import com.hotel.Service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAll(){
		return new ResponseEntity<List<Hotel>> (hotelServiceImpl.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Hotel> getByID(@PathVariable Integer id){
		return new ResponseEntity<Hotel>(hotelServiceImpl.getById(id), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelServiceImpl.addHotel(hotel) ,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelServiceImpl.updateHotel(hotel) , HttpStatus.OK);
	}
}
