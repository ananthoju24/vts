package com.vts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "T_HOUSE_DETAILS")
public class HouseInfo extends BaseEntity {

	private static final long serialVersionUID = -6117860564098720241L;

	@Column(name = "F_HOUSE_ID", nullable = false)
	@Id
	@SequenceGenerator(name = "taxId", initialValue = 10000)
	@GeneratedValue(generator = "taxId", strategy = GenerationType.SEQUENCE)
	private Long houseID;

	@ManyToOne
	@JoinColumn(name = "F_OWNER_ID")
	private OwnerInfo ownerInfo;

	@Column(name = "F_HOUSE_NO", nullable = false, unique = true)
	private String houseNumber;

}
