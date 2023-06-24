package me.dstepanets.userservice.service;

import me.dstepanets.userservice.domain.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(ObjectId id);
}
