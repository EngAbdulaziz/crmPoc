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
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = -2889262611051008248L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Customer_Id")
	private Integer customerId;
	@Basic(optional = false)
	@Column(name = "Customer_Name")
	private String customerName;
	@Basic(optional = false)
	@Column(name = "Customer_Main_Mobile")
	private String customerMainMobile;
	@Basic(optional = false)
	@Column(name = "Customer_Email")
	private String customerEmail;
	@Basic(optional = false)
	@Column(name = "Customer_Second_Mobile")
	private String customerSecondMobile;
	@Basic(optional = false)
	@Column(name = "Customer_Phone")
	private String customerPhone;
	@Basic(optional = false)
	@Column(name = "Customer_Address")
	private String customerAddress;
	@Column(name = "Ope_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date opeDate;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@OneToMany(mappedBy = "notificationRelatedCustomer", fetch = FetchType.LAZY)
	private Collection<SystemNotification> systemNotificationCollection;
	@JoinColumn(name = "Customer_City", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup customerCity;
	@JoinColumn(name = "Customer_Governorate", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup customerGovernorate;
	@JoinColumn(name = "Customer_Region", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup customerRegion;
	@JoinColumn(name = "Ope_Id", referencedColumnName = "user_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SystemUser opeId;
	@JoinColumn(name = "Customer_Type", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup customerType;

	public Customer() {
	}

	public Customer(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer(Integer customerId, String customerName, String customerMainMobile, String customerEmail,
			String customerSecondMobile, String customerPhone, String customerAddress, boolean deleted) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMainMobile = customerMainMobile;
		this.customerEmail = customerEmail;
		this.customerSecondMobile = customerSecondMobile;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.deleted = deleted;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMainMobile() {
		return customerMainMobile;
	}

	public void setCustomerMainMobile(String customerMainMobile) {
		this.customerMainMobile = customerMainMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerSecondMobile() {
		return customerSecondMobile;
	}

	public void setCustomerSecondMobile(String customerSecondMobile) {
		this.customerSecondMobile = customerSecondMobile;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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

	public Lookup getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(Lookup customerCity) {
		this.customerCity = customerCity;
	}

	public Lookup getCustomerGovernorate() {
		return customerGovernorate;
	}

	public void setCustomerGovernorate(Lookup customerGovernorate) {
		this.customerGovernorate = customerGovernorate;
	}

	public Lookup getCustomerRegion() {
		return customerRegion;
	}

	public void setCustomerRegion(Lookup customerRegion) {
		this.customerRegion = customerRegion;
	}

	public SystemUser getOpeId() {
		return opeId;
	}

	public void setOpeId(SystemUser opeId) {
		this.opeId = opeId;
	}

	public Lookup getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Lookup customerType) {
		this.customerType = customerType;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (customerId != null ? customerId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.customerId == null && other.customerId != null)
				|| (this.customerId != null && !this.customerId.equals(other.customerId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.Customer[ customerId=" + customerId + " ]";
	}

}
