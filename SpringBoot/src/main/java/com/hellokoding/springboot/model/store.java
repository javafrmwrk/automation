package com.hellokoding.springboot.model;
import javax.persistence.*;
import javax.persistence.Entity ;
import javax.persistence.Id;

@Entity
public class store {

	@Id
	 @Column(name="storeId",updatable = false, nullable = false)
	  private Integer storeId;

	@Column(name="storeName")
	private String storeName;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


}
