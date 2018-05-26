/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codevalley.crm.entity;

import java.io.Serializable;
import java.util.Collection;

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

/**
 *
 * @author Abdulaziz
 */
@Entity
@Table(name = "lookup")
public class Lookup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8970057019782941935L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Lookup_Id")
	private Integer lookupId;
	@Basic(optional = false)
	@Column(name = "Lookup_Name")
	private String lookupName;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@JoinColumn(name = "Lookup_Type_Id", referencedColumnName = "Lookup_Type_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private LookupType lookupTypeId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationStatus", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection;
	@OneToMany(mappedBy = "notificationPriority", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeDepartment", fetch = FetchType.LAZY)
	private Collection<Employee> employeeCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeType", fetch = FetchType.LAZY)
	private Collection<Employee> employeeCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerCity", fetch = FetchType.LAZY)
	private Collection<Customer> customerCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerGovernorate", fetch = FetchType.LAZY)
	private Collection<Customer> customerCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerRegion", fetch = FetchType.LAZY)
	private Collection<Customer> customerCollection2;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerType", fetch = FetchType.LAZY)
	private Collection<Customer> customerCollection3;

	public Lookup() {
	}

	public Lookup(Integer lookupId) {
		this.lookupId = lookupId;
	}

	public Lookup(Integer lookupId, String lookupName, boolean deleted) {
		this.lookupId = lookupId;
		this.lookupName = lookupName;
		this.deleted = deleted;
	}

	public Integer getLookupId() {
		return lookupId;
	}

	public void setLookupId(Integer lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LookupType getLookupTypeId() {
		return lookupTypeId;
	}

	public void setLookupTypeId(LookupType lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
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

	public Collection<Customer> getCustomerCollection1() {
		return customerCollection1;
	}

	public void setCustomerCollection1(Collection<Customer> customerCollection1) {
		this.customerCollection1 = customerCollection1;
	}

	public Collection<Customer> getCustomerCollection2() {
		return customerCollection2;
	}

	public void setCustomerCollection2(Collection<Customer> customerCollection2) {
		this.customerCollection2 = customerCollection2;
	}

	public Collection<Customer> getCustomerCollection3() {
		return customerCollection3;
	}

	public void setCustomerCollection3(Collection<Customer> customerCollection3) {
		this.customerCollection3 = customerCollection3;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lookupId != null ? lookupId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Lookup)) {
			return false;
		}
		Lookup other = (Lookup) object;
		if ((this.lookupId == null && other.lookupId != null)
				|| (this.lookupId != null && !this.lookupId.equals(other.lookupId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.Lookup[ lookupId=" + lookupId + " ]";
	}

}
