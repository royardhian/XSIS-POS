package com.bootcamp.pos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.bootcamp.pos.model.MstEmployeeOutletModel;

@Entity
@Table(name="POS_MST_EMPLOYEE")
public class MstEmployeeModel {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private int haveAccount;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private int active;
	private MstUserModel user;
	private Set<MstEmployeeOutletModel> employeeOutlet=new HashSet<MstEmployeeOutletModel>(0);
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MST_EMPLOYEE")
	@TableGenerator(name="MST_EMPLOYEE", table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_EMPLOYEE", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="FIRST_NAME", length=50, nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="EMAIL", length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="TITLE", length=50)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="HAVE_ACCOUNT", length=1, nullable=false)
	public int getHaveAccount() {
		return haveAccount;
	}
	public void setHaveAccount(int haveAccount) {
		this.haveAccount = haveAccount;
	}
	
	@Column(name="CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="MODIFIED_BY")
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name="ACTIVE", nullable=false)
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@OneToOne(mappedBy="employee", fetch=FetchType.EAGER)
	public MstUserModel getUser() {
		return user;
	}
	public void setUser(MstUserModel user) {
		this.user = user;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="employee")
	@JsonManagedReference
	public Set<MstEmployeeOutletModel> getOutlet() {
		return employeeOutlet;
	}
	public void setOutlet(Set<MstEmployeeOutletModel> outlet) {
		this.employeeOutlet = outlet;
	}
	
	
	
}
