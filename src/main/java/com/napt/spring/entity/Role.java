package com.napt.spring.entity;

// Generated Apr 6, 2017 9:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "money_interest_manager")
public class Role implements java.io.Serializable {

	private Integer id;
	private String name;
	private boolean isRoot;
	private int parentRoleId;

	public Role() {
	}

	public Role(String name, boolean isRoot, int parentRoleId) {
		this.name = name;
		this.isRoot = isRoot;
		this.parentRoleId = parentRoleId;
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

	@Column(name = "Name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IsRoot", nullable = false)
	public boolean isIsRoot() {
		return this.isRoot;
	}

	public void setIsRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	@Column(name = "ParentRoleId", nullable = false)
	public int getParentRoleId() {
		return this.parentRoleId;
	}

	public void setParentRoleId(int parentRoleId) {
		this.parentRoleId = parentRoleId;
	}

}
