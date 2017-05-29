package com.bootcamp.pos.viewmodel;

import java.util.Date;
import java.util.List;

public class MstEmployeeViewModel {
	private int id;
	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private int haveAccount;	
	private Date createdOn;
	private int createdBy;
	private Date modifiedOn;
	private int modifiedBy;
	private int active;
	
	//account
	private int roleId;
	private String userName;
	private String password;
	
	// outlet
	private List<Integer> outletId;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}

	public int getHaveAccount() {
		return haveAccount;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public int getActive() {
		return active;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public List<Integer> getOutletId() {
		return outletId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHaveAccount(int haveAccount) {
		this.haveAccount = haveAccount;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOutletId(List<Integer> outletId) {
		this.outletId = outletId;
	}
}
