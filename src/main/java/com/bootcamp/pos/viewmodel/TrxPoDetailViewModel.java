/**
 * 
 */
package com.bootcamp.pos.viewmodel;

import java.util.Date;

/**
 * @author Beni Rama
 *
 * '_'
 */
public class TrxPoDetailViewModel {

	private int id;
	private int poId;
	private int variantId;
	private int requestQty;
	private Double unitCost;
	private Double subTotal;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public int getVariantId() {
		return variantId;
	}
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}
	public int getRequestQty() {
		return requestQty;
	}
	public void setRequestQty(int requestQty) {
		this.requestQty = requestQty;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
