package com.example.demo.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private String SECRET_KEY;

	public String extractUsername(String token)
	{
		return extractClaim(token,Claims::getSubject);
	}
	
	public Claims extractAllClaims(String token)
	{
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
		
	}
	
	public <T> T extractClaim(String token,Function<Claims,T> claimsResolver)
	{
		Claims claims=extractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	public String generateToken(UserDetails userdetails) {
		return generateToken(new HashMap<>(),userdetails);
	}
	
	public String generateToken(Map<String,Object> extraclaims,UserDetails userdetails)
	{
		
		return Jwts.builder().setClaims(extraclaims).setSubject(userdetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*24*60)).signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
		
	}
	
	public boolean isTokenValid(String token,UserDetails userdetails) {
		String username=extractUsername(token);
		return (username.equals(userdetails.getUsername())) && !isTokenExpired(token) ;
		
	}

	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token,Claims::getExpiration);
	}

	private Key getSignInKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
		
	}
}
