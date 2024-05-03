package com.hotel.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.Entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
