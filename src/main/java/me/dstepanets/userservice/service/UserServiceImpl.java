package me.dstepanets.userservice.service;

import lombok.AllArgsConstructor;
import me.dstepanets.userservice.domain.User;
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

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(ObjectId id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
}
