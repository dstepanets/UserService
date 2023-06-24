package me.dstepanets.userservice.exception;

import org.bson.types.ObjectId;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(ObjectId id) {
		super("Could not find user with ID: " + id);
	}
}
