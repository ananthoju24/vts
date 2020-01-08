package com.vts.service.dao.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vts.beans.Owner;
import com.vts.beans.User;
import com.vts.respository.service.OwnerRepository;
import com.vts.respository.service.UserRepository;

@Service
public class VtsDaoService {

	private static final Logger logger = LogManager.getLogger(VtsDaoService.class);

	@Autowired
	private UserRepository userRepository;
	
	private OwnerRepository ownerRepository;

	public Optional<User> getUser(String username) {
		logger.info("getUser :: loading data from DB for reqested user " + username);
		Optional<User> user = userRepository.findById(username);
		return user;
	}
	
	public Owner create(Owner owner){
		ownerRepository.save(owner);
		return owner;
		
	}
	
//	public String createEnroll(String ownerName,)

}
