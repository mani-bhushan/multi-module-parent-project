package com.apps.org.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apps.org.custom.exceptions.UserNameFoundException;
import com.apps.org.dao.repositories.UserRepository;
import com.apps.org.entity.DAOUser;
import com.apps.org.model.UserDTO;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		DAOUser user = userDao.findByEmail("mani.bhushan@gmail.com");
		System.out.print(user.toString());
		user = userDao.findByName(name);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + name);
		}
		return new User (
				user.getName(),
				user.getPassword(),
				new ArrayList<>());
		
		
	}

	public DAOUser save(UserDTO user) throws UserNameFoundException {
		
		DAOUser newUser = userDao.findByName(user.getName());
		if (newUser != null) {
			throw new UserNameFoundException("User found with username: " + user.getName());
		} else {
			newUser = new DAOUser();
			newUser.setName(user.getName());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			return userDao.save(newUser);
		}
	}

}