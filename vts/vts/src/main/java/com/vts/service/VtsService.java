package com.vts.service;

import org.springframework.stereotype.Component;

import com.vts.beans.Owner;
import com.vts.beans.TaxDetails;

@Component
public interface VtsService {

	public boolean validateUser(String userName, String password);

	public TaxDetails geTaxDetails(String hno);
	
	public Owner create(Owner owner);
	
}
