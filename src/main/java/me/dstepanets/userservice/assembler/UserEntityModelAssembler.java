package me.dstepanets.userservice.assembler;

import me.dstepanets.userservice.controller.UserController;
import me.dstepanets.userservice.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserEntityModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

	@Override
	public EntityModel<User> toModel(User entity) {
		return EntityModel.of(
				entity,
				linkTo(methodOn(UserController.class).getUserById(entity.getId().toHexString())).withSelfRel(),
				linkTo(methodOn(UserController.class).getAllUsers()).withRel("users")
		);
	}
}
