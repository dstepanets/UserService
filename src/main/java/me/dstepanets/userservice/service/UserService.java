package me.dstepanets.userservice.service;

import me.dstepanets.userservice.domain.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
}
