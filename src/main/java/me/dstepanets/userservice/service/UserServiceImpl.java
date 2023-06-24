package me.dstepanets.userservice.service;

import lombok.AllArgsConstructor;
import me.dstepanets.userservice.dto.Mapper;
import me.dstepanets.userservice.dto.UserDto;
import me.dstepanets.userservice.entity.User;
import me.dstepanets.userservice.exception.UserNotFoundException;
import me.dstepanets.userservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private Mapper<User, UserDto> mapper;
	private Validator<UserDto> validator;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(ObjectId id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public User createUser(UserDto userDto) {
		validator.validate(userDto);
		return userRepository.save(mapper.dtoToEntity(userDto));
	}

	public User updateUser(ObjectId id, UserDto updatedUser) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		validator.validate(updatedUser);
		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());

		return userRepository.save(existingUser);
	}
}
