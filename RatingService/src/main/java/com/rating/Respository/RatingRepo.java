package com.rating.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserId(Integer id);
	List<Rating> findByHotelId(Integer id);
	
}
