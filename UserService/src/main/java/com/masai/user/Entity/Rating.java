package com.masai.user.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
