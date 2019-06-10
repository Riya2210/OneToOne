package com.alliance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_contact", catalog = "mapping")
public class UsersContact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4498405942850314229L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	private Integer phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Users users;

	public UsersContact() {
	}

	public Users getUsers() {
		return users;
	}

	public UsersContact setUsers(Users users) {
		this.users = users;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public UsersContact setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public UsersContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}
}