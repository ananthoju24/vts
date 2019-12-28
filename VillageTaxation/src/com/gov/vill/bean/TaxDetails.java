package com.gov.vill.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TaxDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ownerName;
	private String hno;
	private List<TaxData> taxDataList;
	private TaxData currentTaxData;
	private TaxData dueTaxData;
	private String date;
}
