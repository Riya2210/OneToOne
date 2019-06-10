package com.alliance.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", catalog = "mapping")
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090064049121800081L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	private Integer salary;
	@Column(name = "team_name")
	private String teamName;

	public Users() {

	}

	public Integer getId() {
		return id;
	}

	public Users setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Users setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getSalary() {
		return salary;
	}

	public Users setSalary(Integer salary) {
		this.salary = salary;
		return this;
	}

	public String getTeamName() {
		return teamName;
	}

	public Users setTeamName(String teamName) {
		this.teamName = teamName;
		return this;
	}

}