package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.repository.EmployeeRepo;

@Service
public class AuthenticationService {
	@Autowired
	private EmployeeRepo er;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;
	private AuthenticationResponse auth;
	private AuthenticationManager am;
	public AuthenticationResponse register(RegisterRequest request)
	{
//		var user=User.builder().firstname(request.getFirstname()).lastname(request.getLastname()).email(request.getEmail()).build();
		Employee e=new Employee();
		e.setFirstname(request.getFirstname());
		e.setLastname(request.getLastname());
		e.setUseremail(request.getEmail());
		e.setPassword(passwordEncoder.encode(request.getPassword()));
		e.setRole(Role.EMPLOYEE);
		er.save(e);
		String jwtToken=jwtService.generateToken(e);
		auth.token=jwtToken;
		return auth;
		
		
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest ar)
	{
		am.authenticate(new UsernamePasswordAuthenticationToken(
				ar.getUsername(),
				ar.getPassword()
				));
		
		Employee e=er.findByUserEmail(ar.getUsername());
		String token=jwtService.generateToken(e);
		auth.token=token;
		return auth;
	}

}
