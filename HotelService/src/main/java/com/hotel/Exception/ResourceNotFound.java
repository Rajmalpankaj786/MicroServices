package com.hotel.Exception;

public class ResourceNotFound extends RuntimeException{

	public ResourceNotFound() {
		super("resource not found Exception");
	}
	
	public ResourceNotFound(String msg) {
		super(msg);
	}
	
}
