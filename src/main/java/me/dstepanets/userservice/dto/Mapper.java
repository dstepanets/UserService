package me.dstepanets.userservice.dto;

public interface Mapper<E, D> {

	E dtoToEntity(D dto);
}
