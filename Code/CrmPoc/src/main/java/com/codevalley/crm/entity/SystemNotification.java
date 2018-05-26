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
@Table(name = "system_notification")
public class SystemNotification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2925999350344402510L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Notification_Id")
	private Integer notificationId;
	@Basic(optional = false)
	@Column(name = "Notification_Tittle")
	private String notificationTittle;
	@Basic(optional = false)
	@Column(name = "Notification_Body")
	private String notificationBody;
	@Basic(optional = false)
	@Column(name = "Notification_Creation_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationCreationDate;
	@Basic(optional = false)
	@Column(name = "Notification_Due_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationDueDate;
	@Basic(optional = false)
	@Column(name = "Notification_End_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationEndDate;
	@Column(name = "Ope_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date opeDate;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@JoinColumn(name = "Notification_Related_Customer", referencedColumnName = "Customer_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer notificationRelatedCustomer;
	@JoinColumn(name = "Notification_Status", referencedColumnName = "Lookup_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lookup notificationStatus;
	@JoinColumn(name = "Notification_Priority", referencedColumnName = "Lookup_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Lookup notificationPriority;
	@JoinColumn(name = "Notification_Assignee_User", referencedColumnName = "user_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SystemUser notificationAssigneeUser;
	@JoinColumn(name = "Ope_Id", referencedColumnName = "user_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SystemUser opeId;
	@JoinColumn(name = "Notification_Created_By", referencedColumnName = "user_Id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SystemUser notificationCreatedBy;

	public SystemNotification() {
	}

	public SystemNotification(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public SystemNotification(Integer notificationId, String notificationTittle, String notificationBody,
			Date notificationCreationDate, Date notificationDueDate, Date notificationEndDate, boolean deleted) {
		this.notificationId = notificationId;
		this.notificationTittle = notificationTittle;
		this.notificationBody = notificationBody;
		this.notificationCreationDate = notificationCreationDate;
		this.notificationDueDate = notificationDueDate;
		this.notificationEndDate = notificationEndDate;
		this.deleted = deleted;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationTittle() {
		return notificationTittle;
	}

	public void setNotificationTittle(String notificationTittle) {
		this.notificationTittle = notificationTittle;
	}

	public String getNotificationBody() {
		return notificationBody;
	}

	public void setNotificationBody(String notificationBody) {
		this.notificationBody = notificationBody;
	}

	public Date getNotificationCreationDate() {
		return notificationCreationDate;
	}

	public void setNotificationCreationDate(Date notificationCreationDate) {
		this.notificationCreationDate = notificationCreationDate;
	}

	public Date getNotificationDueDate() {
		return notificationDueDate;
	}

	public void setNotificationDueDate(Date notificationDueDate) {
		this.notificationDueDate = notificationDueDate;
	}

	public Date getNotificationEndDate() {
		return notificationEndDate;
	}

	public void setNotificationEndDate(Date notificationEndDate) {
		this.notificationEndDate = notificationEndDate;
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

	public Customer getNotificationRelatedCustomer() {
		return notificationRelatedCustomer;
	}

	public void setNotificationRelatedCustomer(Customer notificationRelatedCustomer) {
		this.notificationRelatedCustomer = notificationRelatedCustomer;
	}

	public Lookup getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(Lookup notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public Lookup getNotificationPriority() {
		return notificationPriority;
	}

	public void setNotificationPriority(Lookup notificationPriority) {
		this.notificationPriority = notificationPriority;
	}

	public SystemUser getNotificationAssigneeUser() {
		return notificationAssigneeUser;
	}

	public void setNotificationAssigneeUser(SystemUser notificationAssigneeUser) {
		this.notificationAssigneeUser = notificationAssigneeUser;
	}

	public SystemUser getOpeId() {
		return opeId;
	}

	public void setOpeId(SystemUser opeId) {
		this.opeId = opeId;
	}

	public SystemUser getNotificationCreatedBy() {
		return notificationCreatedBy;
	}

	public void setNotificationCreatedBy(SystemUser notificationCreatedBy) {
		this.notificationCreatedBy = notificationCreatedBy;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (notificationId != null ? notificationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SystemNotification)) {
			return false;
		}
		SystemNotification other = (SystemNotification) object;
		if ((this.notificationId == null && other.notificationId != null)
				|| (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.SystemNotification[ notificationId=" + notificationId + " ]";
	}

}
