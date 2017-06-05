/**
 * 
 */
package com.bootcamp.pos.viewmodel;

import java.util.Date;
import java.util.List;

/**
 * @author Beni Rama
 *
 * '_'
 */
public class TrxPoViewModel {
	
	private int id;
	private int prId;
	private int outletId;
	private int supplierId;
	private String poNo;
	private String notes;
	private Double grandTotal;
	private String status;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private List<TrxPoDetailViewModel> detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	public int getOutletId() {
		return outletId;
	}
	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public List<TrxPoDetailViewModel> getDetail() {
		return detail;
	}
	public void setDetail(List<TrxPoDetailViewModel> detail) {
		this.detail = detail;
	}
	
	
}
