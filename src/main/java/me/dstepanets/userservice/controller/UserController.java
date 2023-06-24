package me.dstepanets.userservice.controller;

import lombok.AllArgsConstructor;
import me.dstepanets.userservice.assembler.UserEntityModelAssembler;
import me.dstepanets.userservice.dto.UserDto;
import me.dstepanets.userservice.entity.User;
import me.dstepanets.userservice.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

	private final UserService userService;
	private final UserEntityModelAssembler entityModelAssembler;

	@GetMapping
	public CollectionModel<EntityModel<User>> getAllUsers() {
		List<EntityModel<User>> userModels = userService.getAllUsers().stream()
				.map(entityModelAssembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(
				userModels, 
				WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers())
						.withSelfRel()
		);
	}

	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable String id) {
		User user = userService.getUserById(new ObjectId(id));

		return entityModelAssembler.toModel(user);
	}

	@PostMapping
	public ResponseEntity<EntityModel<User>> createUser(@RequestBody UserDto userDto) {
		User createdUser = userService.createUser(userDto);
		EntityModel<User> userEntityModel = entityModelAssembler.toModel(createdUser);

		return ResponseEntity
				.created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(userEntityModel);
	}

	@PutMapping("/{id}")
	public EntityModel<User> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
		User updatedUser = userService.updateUser(new ObjectId(id), userDto);

		return entityModelAssembler.toModel(updatedUser);
	}
}
