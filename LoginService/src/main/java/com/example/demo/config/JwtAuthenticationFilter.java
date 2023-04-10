package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.Data;
import lombok.NonNull;

@Data
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private UserDetailsService userdetailservice;
	private JwtService jwtservice;
	private UserDetails userdetails;
	@Override
	protected void doFilterInternal( @NonNull HttpServletRequest request, 
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authHeader=request.getHeader("Authorization");
		final String jwt;
		if(authHeader==null || !authHeader.startsWith("Bearer "))
		{
			filterChain.doFilter(request, response);
			return;
		}
		jwt=authHeader.substring(7);
		String useremail=jwtservice.extractUsername(jwt);
		if(useremail!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails ud=userdetailservice.loadUserByUsername(useremail);
		}
		if(jwtservice.isTokenValid(useremail, userdetails))
		{
			UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
					userdetails,
					null,
					userdetails.getAuthorities()
					
					);
			
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
		
		}
	}

}
