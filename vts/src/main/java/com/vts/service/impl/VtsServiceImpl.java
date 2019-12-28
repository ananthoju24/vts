package com.vts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vts.beans.TaxDetails;
import com.vts.service.VtsService;
import com.vts.service.dao.TaxDao;

@Component
public class VtsServiceImpl implements VtsService {

	@Autowired
	TaxDao taxDao;

	@Override
	public boolean validateUser(String userName, String password) {
		if ("admin".equals(userName) && "1234".equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public TaxDetails geTaxDetails(String hno) {
		TaxDetails taxDetails = taxDao.geTaxDetails(hno);
		return taxDetails;
	}

}
