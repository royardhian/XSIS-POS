package com.bootcamp.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="MST_SERVER_PASS")
public class MstServerPassModel {
	private int id;
	private int serverId;
	private int passId;
	private MstServerModel server;
	private MstPassModel pass;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MSR_SERVER_PASS")
	@TableGenerator(name="MST_SERVER_PASS",table="MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_SERVER_PASS", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="SERVER_ID")
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	
	@Column(name="PASS_ID")
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SERVER_ID",nullable=false,insertable=false, updatable=false)
	public MstServerModel getServer() {
		return server;
	}
	public void setServer(MstServerModel server) {
		this.server = server;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PASS_ID",nullable=false,insertable=false, updatable=false)
	public MstPassModel getPass() {
		return pass;
	}
	public void setPass(MstPassModel pass) {
		this.pass = pass;
	}
}
