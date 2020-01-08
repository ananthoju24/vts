package com.vts.service.impl;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "T_OWNER_DETAILS")
public class Owner {

	@Column(name = "F_OWNER_ID")
	@Id
	private String ownerID;

	@Column(name = "F_OWNER_NAME")
	private String ownerName;

	@Column(name = "F_OWNER_HOUSE_NUMBER")
	private String houseNumber;

	@Column(name = "F_CREATE_DATE")
	private Date createDate;

	@Column(name = "F_UPDATE_DATE")
	private Date updateDate;

}
