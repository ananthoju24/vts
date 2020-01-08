package com.vts.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.vts.entity.BaseEntity;
import com.vts.entity.HouseInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "T_TAX_DETAILS")
@Data
@EqualsAndHashCode(callSuper = true)
public class TaxInfo extends BaseEntity {

	private static final long serialVersionUID = 104363229610299397L;

	@Column(name = "F_TAX_ID", nullable = false)
	@Id
	@SequenceGenerator(name = "taxId", initialValue = 100000)
	@GeneratedValue(generator = "taxId", strategy = GenerationType.SEQUENCE)
	private Long taxID;

	@ManyToOne
	@JoinColumn(name = "F_HOUSE_ID")
	private HouseInfo houseInfo;

	@Column(name = "F_HOUSE_TAX", nullable = false)
	private String houseTax;

	@Column(name = "F_VILLAGE_TAX", nullable = false)
	private String villageTax;

	@Column(name = "F_WATER_TAX", nullable = false)
	private String waterTax;

	@Column(name = "F_LIGHTHING_TAX", nullable = false)
	private String lighthingTax;

	@Column(name = "F_CLEANING_TAX", nullable = false)
	private String cleaningTax;

	@Column(name = "F_TOTAL_TAX", nullable = false)
	private String totalTax;

	@Column(name = "F_TAX_YEAR", nullable = false)
	private String taxYear;

	@Column(name = "F_TAX_STATUS", nullable = false)
	private String taxStatus;

}
