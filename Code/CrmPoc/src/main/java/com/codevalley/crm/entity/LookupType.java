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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abdulaziz
 */
@Entity
@Table(name = "lookup_type")
public class LookupType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670179801284455327L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Lookup_Type_Id")
	private Integer lookupTypeId;
	@Basic(optional = false)
	@Column(name = "Lookup_Type_Name")
	private String lookupTypeName;
	@Basic(optional = false)
	@Column(name = "Deleted")
	private boolean deleted;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lookupTypeId", fetch = FetchType.LAZY)
	private Collection<Lookup> lookupCollection;

	public LookupType() {
	}

	public LookupType(Integer lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
	}

	public LookupType(Integer lookupTypeId, String lookupTypeName, boolean deleted) {
		this.lookupTypeId = lookupTypeId;
		this.lookupTypeName = lookupTypeName;
		this.deleted = deleted;
	}

	public Integer getLookupTypeId() {
		return lookupTypeId;
	}

	public void setLookupTypeId(Integer lookupTypeId) {
		this.lookupTypeId = lookupTypeId;
	}

	public String getLookupTypeName() {
		return lookupTypeName;
	}

	public void setLookupTypeName(String lookupTypeName) {
		this.lookupTypeName = lookupTypeName;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Collection<Lookup> getLookupCollection() {
		return lookupCollection;
	}

	public void setLookupCollection(Collection<Lookup> lookupCollection) {
		this.lookupCollection = lookupCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lookupTypeId != null ? lookupTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof LookupType)) {
			return false;
		}
		LookupType other = (LookupType) object;
		if ((this.lookupTypeId == null && other.lookupTypeId != null)
				|| (this.lookupTypeId != null && !this.lookupTypeId.equals(other.lookupTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.codevalley.crm.entity.LookupType[ lookupTypeId=" + lookupTypeId + " ]";
	}

}
