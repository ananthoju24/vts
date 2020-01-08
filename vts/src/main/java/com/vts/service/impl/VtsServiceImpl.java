package com.vts.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vts.beans.OwnerBean;
import com.vts.beans.TaxDetails;
import com.vts.entity.HouseInfo;
import com.vts.entity.OwnerInfo;
import com.vts.entity.User;
import com.vts.response.VTSRespone;
import com.vts.respository.service.OwnerRepository;
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

	@Autowired
	OwnerRepository ownerRepository;

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
		return false;
	}

	@Override
	public TaxDetails geTaxDetails(String hno) {
		TaxDetails taxDetails = taxDao.geTaxDetails(hno);
		return taxDetails;
	}

	@Override
	public VTSRespone addOwner(OwnerBean owner) {
		logger.info("vtsService ::owner data from controller " + owner);
		VTSRespone vtsResponse = new VTSRespone();
		logger.info("addOnwerDetails :: request to add new onwer to system :: " + owner);
		try {

			OwnerInfo ownerInfo = new OwnerInfo();
			ownerInfo.setOwnerName(owner.getOwnerName());
			ownerInfo.setMobileNumber(owner.getMobileNumber());
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setHouseNumber(owner.getHouseNumber());
			houseInfo.setOwnerInfo(ownerInfo);

			String response = vtsDaoService.saveOwnerandHouseInfo(ownerInfo, houseInfo);
			if (null != response && "SUCCESS".equalsIgnoreCase(response)) {
				vtsResponse.setRespCode(201);
				vtsResponse.setRespDesc("Owner creation success");
			} else {
				vtsResponse.setRespCode(404);
				vtsResponse.setRespDesc("Owner creation failed.Please try again");
			}
		} catch (Exception e) {
			logger.error("addOnwerDetails :: failed to add owner to DB ", e);
			vtsResponse.setRespCode(404);
			vtsResponse.setRespDesc("Owner creation failed. Please try again");
		}
		logger.info("addOnwerDetails :: vtsResponse : " + vtsResponse);
		return vtsResponse;
	}

}
