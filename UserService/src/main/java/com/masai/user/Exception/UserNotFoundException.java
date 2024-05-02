package com.masai.user.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
    	super("user not found for the given id");
    }
    
    public UserNotFoundException(String msg) {
    	super(msg);
    }
}
