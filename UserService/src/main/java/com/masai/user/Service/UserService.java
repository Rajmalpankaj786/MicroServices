package com.masai.user.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.masai.user.Entity.User;
import com.masai.user.Exception.UserException;
import com.masai.user.Exception.UserNotFoundException;
import com.masai.user.Repository.UserRepositery;

public class UserService implements UserDetailsService{

	@Autowired
	private UserRepositery userRepositery;

	public User addUser(User user) throws UserException {
		User us = userRepositery.findByEmail(user.getEmail());
		if (us != null) {
			throw new UserException("given email id already exists : " + user.getEmail());
		}
		return userRepositery.save(user);
	}

	public List<User> ViewAllUser() {
		return userRepositery.findAll();
	}

	public User findById(String userID) {
		return userRepositery.findById(userID)
				.orElseThrow(() -> new UserNotFoundException("Given User infomation not exits Id :" + userID));

	}

	public User updateUser(User user, String id) {
		User op = userRepositery.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found for given Id : " + id));
		op.setUsername(user.getUsername());
		op.setEmail(user.getEmail());
		op.setAbout(user.getAbout());
		return userRepositery.save(op);
	}

	public User deleteUser(String id) {
		User op = userRepositery.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found for given Id : " + id));

		userRepositery.deleteById(id);
		return op;

	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User u =userRepositery.findByUserName(username);
		if(u==null) {
			throw new UserNotFoundException("username does not exits : "+username);
		}
		return u;
	}

}
