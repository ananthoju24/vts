package com.vts.beans;

import java.io.Serializable;

import org.apache.catalina.Host;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxInfoBean implements Serializable {

	private static final long serialVersionUID = 570181245958103777L;

	private Long taxId;
	private String hno;
	private long houseTax;
	private long villageTax;
	private long waterTax;
	private long lightingTax;
	private long cleaningTax;
	private long totalTax;
	private String taxYear;
	private String taxStatus;

	public TaxInfoBean(String hno, long houseTax, long villageTax, long waterTax, long lightingTax, long cleaningTax,
			long totalTax) {
		this.hno = hno;
		this.houseTax = houseTax;
		this.villageTax = villageTax;
		this.waterTax = waterTax;
		this.lightingTax = lightingTax;
		this.cleaningTax = cleaningTax;
		this.totalTax = totalTax;
	}

	public long getTotalTax() {
		this.totalTax = this.houseTax + this.villageTax + this.waterTax + this.lightingTax + this.cleaningTax;
		return totalTax;
	}

	public String getTaxStatus() {
		if (null == this.taxStatus) {
			return "PENDING";
		}
		return this.taxStatus;
	}

}
