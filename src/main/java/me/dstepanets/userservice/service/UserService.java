package me.dstepanets.userservice.service;

import me.dstepanets.userservice.dto.UserDto;
import me.dstepanets.userservice.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(ObjectId id);

	User createUser(UserDto userDto);

	User updateUser(ObjectId id, UserDto updatedUser);
}
