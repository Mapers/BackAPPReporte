package com.cloudsrcsoft.reportes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloudsrcsoft.reportes.repository.jdbc.UserCustomRepository;
import com.cloudsrcsoft.reportes.repository.jpa.UserRepository;
import com.cloudsrcsoft.reportes.security.JwtUserFactory;
import com.cloudsrcsoft.reportes.security.model.User;
import com.cloudsrcsoft.reportes.security.model.UserModel;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCustomRepository userCustomRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
		
		/*UserModel userModel = userCustomRepository.findByUsername(username);
		
		return JwtUserFactory.createJwtUser(userModel);*/
	}

}
