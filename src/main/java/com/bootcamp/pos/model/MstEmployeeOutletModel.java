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
@Table(name="POS_MST_EMPLOYEE_OUTLET")
public class MstEmployeeOutletModel {
	private int id;
	private int employeeId;
	private int outletId;
	private MstEmployeeModel employee;
	private MstOutletModel outlet;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_EMPLOYEE_OUTLET")
	@TableGenerator(name="MST_EMPLOYEE_OUTLET",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_EMPLOYEE_OUTLET", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="EMPLOYEE_ID")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name="OUTLET_ID")
	public int getOutletId() {
		return outletId;
	}
	
	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID",nullable=false,insertable=false, updatable=false)
	public MstEmployeeModel getEmployee() {
		return employee;
	}
	public void setEmployee(MstEmployeeModel employee) {
		this.employee = employee;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OUTLET_ID",nullable=false,insertable=false, updatable=false)
	public MstOutletModel getOutlet() {
		return outlet;
	}
	public void setOutlet(MstOutletModel outlet) {
		this.outlet = outlet;
	}
	
	
}
