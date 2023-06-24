package me.dstepanets.userservice.exception;

public class InvalidUserException extends RuntimeException {

	public InvalidUserException(Throwable cause) {
		super("Provided User object is invalid", cause);
	}
}
