package com.security.springbootjwt.Repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.security.springbootjwt.Entites.user;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<user,Integer> {

     public Optional<user> findByEmail(String email);
}
