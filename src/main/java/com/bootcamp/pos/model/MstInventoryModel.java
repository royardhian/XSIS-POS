package com.bootcamp.pos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_MST_INVENTORY")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="inventoryId")
public class MstInventoryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int outletId;
	private int variantId;
	private int beginningQty;
	private int poQty;
	private int soQty;
	private int tranferQty;
	private int adjustmentQty;
	private int endingQty;
	private int alertAtQty;
	private Date createdOn;
	private int createdBy;
	private Date modifiedOn;
	private int modifiedBy;
	private int active;
	
	private MstItemVariantModel variant;
	/*private MstOutletModel outlet;*/
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_INVENTORY")
	@TableGenerator(name="MST_INVENTORY",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_INVENTORY", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="OUTLET_ID")
	public int getOutletId() {
		return outletId;
	}
	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}
	
	@Column(name="VARIANT_ID")
	public int getVariantId() {
		return variantId;
	}
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}
	
	@Column(name="BEGINNING_QTY")
	public int getBeginningQty() {
		return beginningQty;
	}
	public void setBeginningQty(int beginningQty) {
		this.beginningQty = beginningQty;
	}
	
	@Column(name="PO_QTY")
	public int getPoQty() {
		return poQty;
	}
	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}
	
	@Column(name="SO_QTY")
	public int getSoQty() {
		return soQty;
	}
	public void setSoQty(int soQty) {
		this.soQty = soQty;
	}
	
	@Column(name="TRANSFER_QTY")
	public int getTranferQty() {
		return tranferQty;
	}
	public void setTranferQty(int tranferQty) {
		this.tranferQty = tranferQty;
	}
	
	@Column(name="ADJUSTMENT_QTY")
	public int getAdjustmentQty() {
		return adjustmentQty;
	}
	public void setAdjustmentQty(int adjustmentQty) {
		this.adjustmentQty = adjustmentQty;
	}
	
	@Column(name="ENDING_QTY")
	public int getEndingQty() {
		return endingQty;
	}
	public void setEndingQty(int endingQty) {
		this.endingQty = endingQty;
	}
	
	@Column(name="ALERT_AT_QTY")
	public int getAlertAtQty() {
		return alertAtQty;
	}
	public void setAlertAtQty(int alertAtQty) {
		this.alertAtQty = alertAtQty;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name="MODIFIED_BY")
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="ACTIVE")
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public MstItemVariantModel getVariant() {
		return variant;
	}
	public void setVariant(MstItemVariantModel variant) {
		this.variant = variant;
	}
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OUTLET_ID",nullable=false,insertable=false, updatable=false)
	public MstOutletModel getOutlet() {
		return outlet;
	}
	public void setOutlet(MstOutletModel outlet) {
		this.outlet = outlet;
	}*/
}
