package com.vts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class TaxBaseFileds extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2704883892573314278L;

	@Column(name = "F_HOUSE_TAX", nullable = false)
	protected long houseTax;

	@Column(name = "F_VILLAGE_TAX", nullable = false)
	protected long villageTax;

	@Column(name = "F_WATER_TAX", nullable = false)
	protected long waterTax;

	@Column(name = "F_LIGHTHING_TAX", nullable = false)
	protected long lightingTax;

	@Column(name = "F_CLEANING_TAX", nullable = false)
	protected long cleaningTax;

	@Column(name = "F_TOTAL_TAX", nullable = false)
	protected long totalTax;

	@Column(name = "F_TAX_YEAR", nullable = false)
	protected String taxYear;

	@Column(name = "F_TAX_STATUS", nullable = false)
	protected String taxStatus;
}
