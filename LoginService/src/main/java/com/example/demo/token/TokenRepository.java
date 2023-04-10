package com.example.demo.token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Integer> {

	@Query(value="select t from Token t inner join User u on t.user.id = u.id where u.id = :id and (t.expired = false or t.revoked = false)",nativeQuery=true)
		public   List<Token> findAllValidTokenByUser(@Param("id")Integer id);

		  Optional<Token> findByToken(String token);
}
