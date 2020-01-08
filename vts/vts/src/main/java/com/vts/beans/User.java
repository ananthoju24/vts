package com.vts.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "T_USER_DETAILS")
public class User implements Serializable {

	private static final long serialVersionUID = -7793976415640793209L;
	@Id
	@Column(name = "F_USER_ID")
	private String userName;
	@Column(name = "F_PASSWORD")
	private String password;
	@Column(name = "F_CREATE_DATE")
	private Date createDate;
	// private String roleName;
}
