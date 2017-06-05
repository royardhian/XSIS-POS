package com.bootcamp.pos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "POS_TRX_PO")
public class TrxPoModel {
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

	private TrxPrModel TrxPr;
	private MstOutletModel outlet;
	private MstSupplierModel supplier;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TRX_PO")
	@TableGenerator(name = "TRX_PO", table = "POS_MST_SEQUENCE", pkColumnName = "SEQUENCE_ID", pkColumnValue = "TRX_PO", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "PR_ID")
	public int getPrId() {
		return prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	@Column(name = "OUTLET_ID")
	public int getOutletId() {
		return outletId;
	}

	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}

	@Column(name = "SUPPLIER_ID")
	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Column(name = "PO_NO", length = 50)
	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@Column(name = "NOTES", length = 255)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "GRAND_TOTAL")
	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "MODIFIED_BY")
	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PR_ID", nullable = false, insertable = false, updatable = false)
	public TrxPrModel getTrxPr() {
		return TrxPr;
	}

	public void setTrxPr(TrxPrModel trxPr) {
		TrxPr = trxPr;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OUTLET_ID", nullable = false, insertable = false, updatable = false)
	public MstOutletModel getOutlet() {
		return outlet;
	}

	public void setOutlet(MstOutletModel outlet) {
		this.outlet = outlet;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SUPPLIER_ID", nullable = false, insertable = false, updatable = false)
	public MstSupplierModel getSupplier() {
		return supplier;
	}

	public void setSupplier(MstSupplierModel supplier) {
		this.supplier = supplier;
	}

}