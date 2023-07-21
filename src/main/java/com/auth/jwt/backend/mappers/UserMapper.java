package com.auth.jwt.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.auth.jwt.backend.dto.SignUpDto;
import com.auth.jwt.backend.dto.UserDto;
import com.auth.jwt.backend.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto toUserDto(User user);

	@Mapping(target = "password", ignore = true)
	
	User signUpToUser(SignUpDto signUpDto);
}
