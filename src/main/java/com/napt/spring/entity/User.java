package com.napt.spring.entity;

// Generated Apr 6, 2017 9:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "money_interest_manager")
public class User implements java.io.Serializable {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String identityNumber;
	private String bankIdentityNumber;
	private int provinceId;
	private String pass;

	public User() {
	}

	public User(String name, String phone, String email, String identityNumber,
			String bankIdentityNumber, int provinceId, String pass) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.identityNumber = identityNumber;
		this.bankIdentityNumber = bankIdentityNumber;
		this.provinceId = provinceId;
		this.pass = pass;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Phone", nullable = false, length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Email", nullable = false, length = 80)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "IdentityNumber", nullable = false, length = 20)
	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Column(name = "BankIdentityNumber", nullable = false, length = 20)
	public String getBankIdentityNumber() {
		return this.bankIdentityNumber;
	}

	public void setBankIdentityNumber(String bankIdentityNumber) {
		this.bankIdentityNumber = bankIdentityNumber;
	}

	@Column(name = "ProvinceId", nullable = false)
	public int getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "Pass", nullable = false, length = 100)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
