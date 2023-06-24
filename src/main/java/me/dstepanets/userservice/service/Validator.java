package me.dstepanets.userservice.service;

public interface Validator<T> {

	void validate(T obj);
}
