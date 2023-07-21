package com.auth.jwt.backend.dto;

import com.auth.jwt.backend.dto.UserDto;

public class UserDtoBuilder {
	private UserDto user;

    public UserDtoBuilder() {
        this.user = new UserDto();
    }

    public UserDtoBuilder login(String login) {
        this.user.setLogin(login);
        return this;
    }

    public UserDtoBuilder firstName(String firstName) {
        this.user.setFirstName(firstName);
        return this;
    }
   
    
    public UserDtoBuilder lastName(String lastName) {
        this.user.setLastName(lastName);
        return this;
    }

    public UserDto build() {
        return this.user;
    }
    
}
