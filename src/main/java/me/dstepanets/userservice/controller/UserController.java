package me.dstepanets.userservice.controller;

import lombok.AllArgsConstructor;
import me.dstepanets.userservice.domain.User;
import me.dstepanets.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

	private UserService userService;

	@GetMapping
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
