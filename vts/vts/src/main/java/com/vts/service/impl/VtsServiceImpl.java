package com.vts.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vts.beans.Owner;
import com.vts.beans.TaxDetails;
import com.vts.beans.User;
import com.vts.service.VtsService;
import com.vts.service.dao.TaxDao;
import com.vts.service.dao.impl.VtsDaoService;

@Component
public class VtsServiceImpl implements VtsService {

	static final Logger logger = LogManager.getLogger(VtsServiceImpl.class);
	@Autowired
	TaxDao taxDao;

	@Autowired
	VtsDaoService vtsDaoService;

	@Override
	public boolean validateUser(String userName, String password) {
		logger.info("VtsService :: validating user " + userName + " pwd " + password);
		Optional<User> user = vtsDaoService.getUser(userName);
		logger.info("VtsService :: user object from DB " + user.isPresent());
		if (user.isPresent()) {
			User userData = user.get();
			logger.info("VtsService :: user object from DB " + userData.getUserName());
			if (userData.getUserName().equals(userName) && userData.getPassword().equals(password)) {
				return true;
			}
		}

		/*
		 * if ("admin".equals(userName) && "1234".equals(password)) { return true; }
		 */
		return false;
	}

	@Override
	public TaxDetails geTaxDetails(String hno) {
		TaxDetails taxDetails = taxDao.geTaxDetails(hno);
		return taxDetails;
	}

	
	@Override
	public Owner create(Owner owner) {
		logger.info("vtsService ::owner data from controller " + owner.getOwnerName());
		Owner ownerEntity = new Owner();
		ownerEntity.setOwnerName(owner.getOwnerName());
		ownerEntity.setHno(owner.getHno());
		vtsDaoService.create(ownerEntity);
		logger.info("vtsService ::owner data saved succesfully " );
		return ownerEntity;
	}

}
