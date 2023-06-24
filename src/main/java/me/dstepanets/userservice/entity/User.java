package me.dstepanets.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class User {

	@Id
	private ObjectId id;
	private String name;
	private String email;
}
