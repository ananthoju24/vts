package com.gov.vill.bean;

public interface TaxDao {
	public TaxDetails geTaxData(String hno);
	public int addTaxData(TaxDetails taxDataList);
}
