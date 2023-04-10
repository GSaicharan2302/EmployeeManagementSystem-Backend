package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request)
	{
		return ResponseEntity.ok(authService.register(request));
		
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> request(@RequestBody AuthenticationRequest request)
	{
		return ResponseEntity.ok(authService.authenticate(request));
		
	}
}
