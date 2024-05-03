package com.masai.user.Entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User{
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
	 private String id;
     
     private String username;
     private String password;
     
     private String Email;
     
     private String about;
     
     @Transient
     List<Rating> ratings = new ArrayList<>();
     
    
     
}
