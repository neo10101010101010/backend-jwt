package com.auth.jwt.backend.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.auth.jwt.backend.config.UserAuthenticationProvider;
import com.auth.jwt.backend.dto.CredentialsDto;
import com.auth.jwt.backend.dto.SignUpDto;
import com.auth.jwt.backend.dto.UserDto;
import com.auth.jwt.backend.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    
    public AuthController(UserService userService, UserAuthenticationProvider userAuthenticationProvider)
    {
		this.userService = userService;
		this.userAuthenticationProvider = userAuthenticationProvider;
    	
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
}
