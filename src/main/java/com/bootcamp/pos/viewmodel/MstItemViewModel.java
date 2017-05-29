package com.bootcamp.pos.viewmodel;

import java.util.Date;
import java.util.List;

public class MstItemViewModel {
	private int id;
	private int categoryId;
	private String name;
	private Date createdOn;
	private int createdBy;
	private Date modifiedOn;
	private int modifiedBy;
	private int active;
	private List<MstItemVariantViewModel> variantList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public List<MstItemVariantViewModel> getVariantList() {
		return variantList;
	}
	public void setVariantList(List<MstItemVariantViewModel> variantList) {
		this.variantList = variantList;
	}
}
