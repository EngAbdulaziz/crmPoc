/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codevalley.crm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abdulaziz
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7551090643831566501L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Employee_Id")
	private Integer employeeId;
	@Basic(optional = false)
	@Column(name = "Employee_Name")
	private String employeeName;
	@Basic(optional = false)
	@Column(name = "Employee_Main_Mobile")
	private String employeeMainMobile;
	@Basic(optional = false)
	@Column(name = "Employee_Email")
	private String employeeEmail;
	@Basic(optional = false)
	@Column(name = "Employee_Second_Mobile")
	private String employeeSecondMobile;
	@Basic(optional = false)
	@Column(name = "Employee_Phone")
	private String employeePhone;
	@Basic(optional = false)
	@Column(name = "Employee_Address")
	private String employeeAddress;
	@Column(name = "Ope_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date opeDate;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@JoinColumn(name = "Employee_Department", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup employeeDepartment;
	@JoinColumn(name = "Employee_Type", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup employeeType;
	@JoinColumn(name = "Employee_User", referencedColumnName = "user_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SystemUser employeeUser;
	@JoinColumn(name = "Ope_Id", referencedColumnName = "user_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SystemUser opeId;

	public Employee() {
	}

	public Employee(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Employee(Integer employeeId, String employeeName, String employeeMainMobile, String employeeEmail,
			String employeeSecondMobile, String employeePhone, String employeeAddress, boolean deleted) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeMainMobile = employeeMainMobile;
		this.employeeEmail = employeeEmail;
		this.employeeSecondMobile = employeeSecondMobile;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.deleted = deleted;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeMainMobile() {
		return employeeMainMobile;
	}

	public void setEmployeeMainMobile(String employeeMainMobile) {
		this.employeeMainMobile = employeeMainMobile;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeSecondMobile() {
		return employeeSecondMobile;
	}

	public void setEmployeeSecondMobile(String employeeSecondMobile) {
		this.employeeSecondMobile = employeeSecondMobile;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Date getOpeDate() {
		return opeDate;
	}

	public void setOpeDate(Date opeDate) {
		this.opeDate = opeDate;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Lookup getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(Lookup employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Lookup getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(Lookup employeeType) {
		this.employeeType = employeeType;
	}

	public SystemUser getEmployeeUser() {
		return employeeUser;
	}

	public void setEmployeeUser(SystemUser employeeUser) {
		this.employeeUser = employeeUser;
	}

	public SystemUser getOpeId() {
		return opeId;
	}

	public void setOpeId(SystemUser opeId) {
		this.opeId = opeId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (employeeId != null ? employeeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) object;
		if ((this.employeeId == null && other.employeeId != null)
				|| (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.Employee[ employeeId=" + employeeId + " ]";
	}

}
