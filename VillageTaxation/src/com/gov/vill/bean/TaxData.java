package com.gov.vill.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxData {

	private int ep;
	private int gp;
	private int np;
	private int lp;
	private int pp;
	private String taxYear;
	private String paymentStatus;
	private int totalTaxAmount;

	
}
