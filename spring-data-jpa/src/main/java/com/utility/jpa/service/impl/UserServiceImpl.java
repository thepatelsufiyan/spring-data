package com.utility.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utility.jpa.entity.User;
import com.utility.jpa.repository.UserRepository;
import com.utility.jpa.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean createUser(User user) {
		
		try {
			userRepository.save(user);
			if(user.getUser_Id()!=null) {
				log.info("User Created successfully with ID :"+user.getUser_Id());
				return true;
			}
			log.error("error occured while saving user to db :");
			return false;
		} catch (Exception e) {
			log.error("error occured while saving user to db :"+e.getMessage());
			return false;
		}
		
		
		
	}

}
