package com.rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.Entity.Rating;
import com.rating.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/post")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.addRating(rating) , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRating(){
		return new ResponseEntity<List<Rating>>(ratingService.getAllRating() , HttpStatus.OK);
	}
	
	@GetMapping("/getratingByUserId/{id}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer id){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByUserId(id) , HttpStatus.OK);
	}
	
	@GetMapping("/getratingBYHotelId/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer id){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByHotelId(id) , HttpStatus.OK);
	}
	
	
}
