package com.gov.vill.service;

import com.gov.vill.bean.TaxDetails;
import com.gov.vill.dao.TaxDaoImpl;

public class VillageTaxServiceImpl implements VillageTaxServie {

	private static TaxDaoImpl dao = new TaxDaoImpl();

	@Override
	public TaxDetails geTaxData(String hno) {
		TaxDetails data = dao.geTaxData(hno);
		return data;
	}

	@Override
	public int addTaxData(TaxDetails taxDataList) {
		int respCode = dao.addTaxData(taxDataList);
		return respCode;
	}

}
