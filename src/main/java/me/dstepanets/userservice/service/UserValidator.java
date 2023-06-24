package me.dstepanets.userservice.service;

import me.dstepanets.userservice.dto.UserDto;
import me.dstepanets.userservice.exception.InvalidUserException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator<UserDto> {

	private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

	@Override
	public void validate(UserDto userDto) {
		try {
			Assert.notNull(userDto, "User cannot be null");
			Assert.hasText(userDto.getName(), "User name cannot be empty");
			Assert.isTrue(
					Pattern.compile(EMAIL_PATTERN)
							.matcher(userDto.getEmail())
							.matches(), 
					"Invalid User email"
			);
		} catch (IllegalArgumentException e) {
			throw new InvalidUserException(e);
		}
	}
}
