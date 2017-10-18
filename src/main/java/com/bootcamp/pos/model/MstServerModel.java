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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "MST_SERVER_MODEL")
public class MstServerModel {
	private int id;
	private String serverName;
	private String serverIp;
	private int passId;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private int active;
	
	private Set<MstServerPassModel> serverPass=new HashSet<MstServerPassModel>(0);
	
	
	@Id
	@Column (name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MST_SERVER")
	@TableGenerator(name = "MST_SERVER", table = "POS_MST_SEQUENCE", pkColumnName = "SEQUENCE_ID", pkColumnValue = "MST_SERVER", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name = "SERVER_NAME")
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	@Column (name = "SERVER_IP")
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	@Column (name = "PASS_ID", nullable = false)
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="server")
	@JsonManagedReference
	public Set<MstServerPassModel> getServerPass() {
		return serverPass;
	}
	public void setServerPass(Set<MstServerPassModel> serverPass) {
		this.serverPass = serverPass;
	}
		
	
}
