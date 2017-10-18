package com.bootcamp.pos.model;

import java.util.Date;
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

@Entity
@Table(name="MST_PASS_MODEL")
public class MstPassModel {
	private int id;
	private String username;
	private String password;
	private String description;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private int active;
	private MstServerPassModel server;
	private MstDBModel database;
	
	@Id
	@Column (name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MST_PASS")
	@TableGenerator(name = "MST_PASS", table = "POS_MST_SEQUENCE", pkColumnName = "SEQUENCE_ID", pkColumnValue = "MST_PASS", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name = "USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column (name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column (name = "DESRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	@Column (name = "CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column (name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column (name = "MODIFIED_BY")
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column (name = "MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column (name = "ACTIVE")
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	@OneToOne(mappedBy="pass", fetch=FetchType.EAGER)
	public MstDBModel getDatabase() {
		return database;
	}
	public void setDatabase(MstDBModel database) {
		this.database = database;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="server")
	@JsonManagedReference
	public MstServerPassModel getServer() {
		return server;
	}
	public void setServer(MstServerPassModel server) {
		this.server = server;
	}

	
}
