package com.chase.PhoneBookApplication.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Contact_Details")
public class ContactDtlsEntity {
	@Id
	@Column(name="Id")
	@GeneratedValue
	private Integer cid;
	@Column(name="Name")
	private String cname;
	@Column(name="Email")
	private String cemail;
	@Column(name="PhoneNo")
	private String cnum;

}
