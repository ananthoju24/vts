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

	private String ep;
	private String gp;
	private String np;
	private String lp;
	private String pp;
	private String taxYear;
	private String paymentStatus;
	private String totalTaxAmount;

}
