package com.vts.beans;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity(name="T_OWNER_DETAILS")
@SequenceGenerator(name="ownerid_seq",initialValue=1001)
public class Owner {

	@Column(name = "F_OWNER_ID")
	@Id
	@GeneratedValue(generator="ownerid_seq",strategy=GenerationType.SEQUENCE)
	private Long ownerID;

	@Column(name="F_OWNER_NAME")
	private String ownerName;
	
	@Column(name="F_HOUSE_NO")
	private String hno;
	
	@Column(name="F_CREATE_DATE")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name="F_UPDATE_DATE")
	@UpdateTimestamp
	private Date updateDate;

}
