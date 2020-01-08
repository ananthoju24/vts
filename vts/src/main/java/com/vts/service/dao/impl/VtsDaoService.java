package com.vts.service.dao.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vts.entity.HouseInfo;
import com.vts.entity.OwnerInfo;
import com.vts.entity.User;
import com.vts.respository.service.HouseRepository;
import com.vts.respository.service.OwnerRepository;
import com.vts.respository.service.UserRepository;

@Service
public class VtsDaoService {

	private static final Logger logger = LogManager.getLogger(VtsDaoService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private HouseRepository houseRepository;

	public Optional<User> getUser(String username) {
		logger.info("getUser :: loading data from DB for reqested user " + username);
		Optional<User> user = userRepository.findById(username);
		return user;
	}

	public String saveOwnerandHouseInfo(OwnerInfo ownerInfo, HouseInfo houseInfo) {
		String response = "SUCCESS";
		logger.info("saveOwnerandHouseInfo :: Request to save new owner and house info to system");
		try {
			ownerInfo = ownerRepository.save(ownerInfo);
			logger.info("saveOwnerandHouseInfo :: is owner saved to DB ? :: " + ownerInfo);
			houseInfo = houseRepository.save(houseInfo);
			logger.info("saveOwnerandHouseInfo :: is house saved to DB ? :: " + ownerInfo);
		} catch (Exception e) {
			logger.error("saveOwnerandHouseInfo :: failed to add owner to DB ", e);
			response = "FAILED";
		}
		return response;
	}

}
