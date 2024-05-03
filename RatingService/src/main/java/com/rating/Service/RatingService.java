package com.rating.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.rating.Entity.Rating;
import com.rating.Respository.RatingRepo;



@Service
public class RatingService {

	@Autowired
	private RatingRepo ratingRepo;
	
	public Rating addRating(Rating rating) {
		return ratingRepo.save(rating);
	}
	
	public List<Rating> getAllRating(){
		return ratingRepo.findAll();
	}
	
	public List<Rating> getRatingByUserId(Integer id){
		return ratingRepo.findByUserId(id);
	}
	
	public List<Rating> getRatingByHotelId(Integer id){
		return ratingRepo.findByHotelId(id);
	}
}