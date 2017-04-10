package com.napt.spring.entity;

// Generated Apr 6, 2017 9:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CustomerStoreMap generated by hbm2java
 */
@Entity
@Table(name = "customer_store_map", catalog = "money_interest_manager")
public class CustomerStoreMap implements java.io.Serializable {

	private Integer id;
	private int customerId;
	private int storeId;

	public CustomerStoreMap() {
	}

	public CustomerStoreMap(int customerId, int storeId) {
		this.customerId = customerId;
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

	@Column(name = "Customer_Id", nullable = false)
	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "Store_Id", nullable = false)
	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
