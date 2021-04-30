package com.cloudsrcsoft.reportes.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudsrcsoft.reportes.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
