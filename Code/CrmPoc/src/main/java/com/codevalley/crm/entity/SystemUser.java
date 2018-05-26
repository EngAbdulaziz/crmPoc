/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codevalley.crm.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abdulaziz
 */
@Entity
@Table(name = "system_user")
public class SystemUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8311391091052058641L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_Id")
	private Integer userId;
	@Basic(optional = false)
	@Column(name = "user_Name")
	private String userName;
	@Basic(optional = false)
	@Column(name = "user_passowrd")
	private String userPassowrd;
	@Column(name = "Ope_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date opeDate;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationAssigneeUser", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection;
	@OneToMany(mappedBy = "opeId", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationCreatedBy", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection2;
	@OneToMany(mappedBy = "opeId", fetch = FetchType.LAZY)
	private Collection<SystemUser> systemUserCollection;
	@JoinColumn(name = "Ope_Id", referencedColumnName = "user_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SystemUser opeId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeUser", fetch = FetchType.LAZY)
	private Collection<Employee> employeeCollection;
	@OneToMany(mappedBy = "opeId", fetch = FetchType.LAZY)
	private Collection<Employee> employeeCollection1;
	@OneToMany(mappedBy = "opeId", fetch = FetchType.LAZY)
	private Collection<Customer> customerCollection;

	public SystemUser() {
	}

	public SystemUser(Integer userId) {
		this.userId = userId;
	}

	public SystemUser(Integer userId, String userName, String userPassowrd, boolean deleted) {
		this.userId = userId;
		this.userName = userName;
		this.userPassowrd = userPassowrd;
		this.deleted = deleted;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassowrd() {
		return userPassowrd;
	}

	public void setUserPassowrd(String userPassowrd) {
		this.userPassowrd = userPassowrd;
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

	public Collection<SystemNotification> getSystemNotificationCollection() {
		return systemNotificationCollection;
	}

	public void setSystemNotificationCollection(Collection<SystemNotification> systemNotificationCollection) {
		this.systemNotificationCollection = systemNotificationCollection;
	}

	public Collection<SystemNotification> getSystemNotificationCollection1() {
		return systemNotificationCollection1;
	}

	public void setSystemNotificationCollection1(Collection<SystemNotification> systemNotificationCollection1) {
		this.systemNotificationCollection1 = systemNotificationCollection1;
	}

	public Collection<SystemNotification> getSystemNotificationCollection2() {
		return systemNotificationCollection2;
	}

	public void setSystemNotificationCollection2(Collection<SystemNotification> systemNotificationCollection2) {
		this.systemNotificationCollection2 = systemNotificationCollection2;
	}

	public Collection<SystemUser> getSystemUserCollection() {
		return systemUserCollection;
	}

	public void setSystemUserCollection(Collection<SystemUser> systemUserCollection) {
		this.systemUserCollection = systemUserCollection;
	}

	public SystemUser getOpeId() {
		return opeId;
	}

	public void setOpeId(SystemUser opeId) {
		this.opeId = opeId;
	}

	public Collection<Employee> getEmployeeCollection() {
		return employeeCollection;
	}

	public void setEmployeeCollection(Collection<Employee> employeeCollection) {
		this.employeeCollection = employeeCollection;
	}

	public Collection<Employee> getEmployeeCollection1() {
		return employeeCollection1;
	}

	public void setEmployeeCollection1(Collection<Employee> employeeCollection1) {
		this.employeeCollection1 = employeeCollection1;
	}

	public Collection<Customer> getCustomerCollection() {
		return customerCollection;
	}

	public void setCustomerCollection(Collection<Customer> customerCollection) {
		this.customerCollection = customerCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SystemUser)) {
			return false;
		}
		SystemUser other = (SystemUser) object;
		if ((this.userId == null && other.userId != null)
				|| (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.SystemUser[ userId=" + userId + " ]";
	}

}
