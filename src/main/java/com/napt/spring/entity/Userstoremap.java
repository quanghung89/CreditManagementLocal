package com.napt.spring.entity;

// Generated Apr 6, 2017 9:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userstoremap generated by hbm2java
 */
@Entity
@Table(name = "userstoremap", catalog = "money_interest_manager")
public class Userstoremap implements java.io.Serializable {

	private Integer id;
	private int userId;
	private int storeId;

	public Userstoremap() {
	}

	public Userstoremap(int userId, int storeId) {
		this.userId = userId;
		this.storeId = storeId;
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

	@Column(name = "UserId", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "StoreId", nullable = false)
	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
