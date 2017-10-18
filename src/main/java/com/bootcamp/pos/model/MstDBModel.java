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
@Table (name = "MST_DB_MODEL")
public class MstDBModel {
	private int id;
	private String dbName;
	private String dbIpServer;
	private String dbPort;
	private String dbSID;
	private int passId;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private int active;
	
	private MstPassModel pass;
	
	
	@Id
	@Column (name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MST_DB")
	@TableGenerator(name = "MST_DB", table = "POS_MST_SEQUENCE", pkColumnName = "SEQUENCE_ID", pkColumnValue = "MST_DB", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name = "DB_NAME")
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	@Column (name = "DB_IP_SERVER")
	public String getDbIpServer() {
		return dbIpServer;
	}
	public void setDbIpServer(String dbIpServer) {
		this.dbIpServer = dbIpServer;
	}
	
	@Column (name = "DB_PORT")
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	
	@Column (name = "DB_SID")
	public String getDbSID() {
		return dbSID;
	}
	public void setDbSID(String dbSID) {
		this.dbSID = dbSID;
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
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PASS_ID", nullable = false, insertable = false, updatable = false)
	public MstPassModel getPass() {
		return pass;
	}
	public void setPass(MstPassModel pass) {
		this.pass = pass;
	}
	
	
}
