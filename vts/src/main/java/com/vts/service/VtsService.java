package com.vts.service;

import org.springframework.stereotype.Component;

import com.vts.beans.OwnerBean;
import com.vts.beans.TaxDetails;
import com.vts.response.VTSRespone;

@Component
public interface VtsService {

	public boolean validateUser(String userName, String password);

	public TaxDetails geTaxDetails(String hno);
	
	public VTSRespone addOwner(OwnerBean owner);
	
}
