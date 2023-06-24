package me.dstepanets.userservice.dto;

import me.dstepanets.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {
	@Override
	public User dtoToEntity(UserDto dto) {
		return User.builder()
				.name(dto.getName())
				.email(dto.getEmail())
				.build();
	}
}
