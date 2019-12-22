package com.gov.vill.service;

import com.gov.vill.bean.TaxData;
import com.gov.vill.bean.TaxDetails;

public interface VillageTaxServie {

	public TaxDetails geTaxData(String hno);
	public int addTaxData(TaxDetails taxDataList);
}
