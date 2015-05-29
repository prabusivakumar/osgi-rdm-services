package com.scb.rdm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The Standard Code Picklist Entity define the Picklist values mapped to the
 * Standard Codes.
 * 
 * @author Prabu Sivakumar
 * @version 1.0
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findByCodeIdAndCodeValue", query = "SELECT DISTINCT p FROM StandardCodePicklist p JOIN FETCH p.standardCode JOIN FETCH p.standardCodePicklistValues LEFT JOIN FETCH p.parentStandardCodePicklist WHERE p.standardCode.codeId = ?1 and p.codeValue = ?2"),
		@NamedQuery(name = "findByCodeId", query = "SELECT DISTINCT p FROM StandardCodePicklist p JOIN FETCH p.standardCode JOIN FETCH p.standardCodePicklistValues LEFT JOIN FETCH p.parentStandardCodePicklist WHERE p.standardCode.codeId = ?1") })
@Table(name = "STANDARD_CODE_PICKLIST")
public class StandardCodePicklist implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 6878801434602561775L;

	@Id
	@Column(name = "PICKLIST_ID", precision = 38, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picklist_sequence")
	@SequenceGenerator(name = "picklist_sequence", sequenceName = "PICKLIST_SEQ")
	private BigDecimal id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "CODE_ID", referencedColumnName = "CODE_ID", insertable = true, updatable = true) })
	private StandardCode standardCode;

	@Column(name = "CODE_VALUE", length = 64, insertable = true, updatable = true)
	private String codeValue;

	@Column(name = "APPLICATION_GROUP", length = 16)
	private String applicationGroup;

	@Column(name = "APPLICATION_MODULE", length = 16)
	private String applicationModule;

	@Column(name = "COUNTRY_CODE", length = 8)
	private String countryCode;

	@Column(name = "ENTITY_CODE", length = 16)
	private String entityCode;

	@Column(name = "INSTANCE_CODE", length = 16)
	private String instanceCode;

	@Column(name = "CREATED_BY", length = 120)
	private String createdBy;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "MODIFIED_BY", length = 120)
	private String modifiedBy;

	@Column(name = "MODIFIED_ON", length = 120)
	private String modifiedOn;

	@Column(name = "STATUS", length = 40)
	private String status;

	@Column(name = "DISPLAY_ORDER")
	private Integer displayOrder;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumns({ @JoinColumn(name = "PARENT_PICKLIST_ID", referencedColumnName = "PICKLIST_ID") })
	private StandardCodePicklist parentStandardCodePicklist;

	@Column(name = "EFFECTIVE_START_DATE")
	private Date effectiveStartDate;

	@Column(name = "EFFECTIVE_END_DATE")
	private Date effectiveEndDate;

	@OneToMany(cascade = { javax.persistence.CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumns({
			@javax.persistence.JoinColumn(name = "CODE_ID", referencedColumnName = "CODE_ID", insertable = false, updatable = false),
			@javax.persistence.JoinColumn(name = "CODE_VALUE", referencedColumnName = "CODE_VALUE", insertable = false, updatable = false) })
	private List<StandardCodePicklistValue> standardCodePicklistValues;

	@Transient
	private StandardCodePicklistValue standardCodePicklistValue;

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the standardCode
	 */
	public StandardCode getStandardCode() {
		return standardCode;
	}

	/**
	 * @param standardCode
	 *            the standardCode to set
	 */
	public void setStandardCode(StandardCode standardCode) {
		this.standardCode = standardCode;
	}

	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue
	 *            the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @return the applicationGroup
	 */
	public String getApplicationGroup() {
		return applicationGroup;
	}

	/**
	 * @param applicationGroup
	 *            the applicationGroup to set
	 */
	public void setApplicationGroup(String applicationGroup) {
		this.applicationGroup = applicationGroup;
	}

	/**
	 * @return the applicationModule
	 */
	public String getApplicationModule() {
		return applicationModule;
	}

	/**
	 * @param applicationModule
	 *            the applicationModule to set
	 */
	public void setApplicationModule(String applicationModule) {
		this.applicationModule = applicationModule;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the entityCode
	 */
	public String getEntityCode() {
		return entityCode;
	}

	/**
	 * @param entityCode
	 *            the entityCode to set
	 */
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	/**
	 * @return the instanceCode
	 */
	public String getInstanceCode() {
		return instanceCode;
	}

	/**
	 * @param instanceCode
	 *            the instanceCode to set
	 */
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public String getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn
	 *            the modifiedOn to set
	 */
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder
	 *            the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the parentStandardCodePicklist
	 */
	public StandardCodePicklist getParentStandardCodePicklist() {
		return parentStandardCodePicklist;
	}

	/**
	 * @param parentStandardCodePicklist
	 *            the parentStandardCodePicklist to set
	 */
	public void setParentStandardCodePicklist(
			StandardCodePicklist parentStandardCodePicklist) {
		this.parentStandardCodePicklist = parentStandardCodePicklist;
	}

	/**
	 * @return the effectiveStartDate
	 */
	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	/**
	 * @param effectiveStartDate
	 *            the effectiveStartDate to set
	 */
	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	/**
	 * @return the effectiveEndDate
	 */
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	/**
	 * @param effectiveEndDate
	 *            the effectiveEndDate to set
	 */
	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	/**
	 * @return the standardCodePicklistValue
	 */
	public StandardCodePicklistValue getStandardCodePicklistValue() {
		return standardCodePicklistValue;
	}

	/**
	 * @param standardCodePicklistValue
	 *            the standardCodePicklistValue to set
	 */
	public void setStandardCodePicklistValue(
			StandardCodePicklistValue standardCodePicklistValue) {
		this.standardCodePicklistValue = standardCodePicklistValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((applicationGroup == null) ? 0 : applicationGroup.hashCode());
		result = prime
				* result
				+ ((applicationModule == null) ? 0 : applicationModule
						.hashCode());
		result = prime * result
				+ ((codeValue == null) ? 0 : codeValue.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result
				+ ((displayOrder == null) ? 0 : displayOrder.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime
				* result
				+ ((effectiveStartDate == null) ? 0 : effectiveStartDate
						.hashCode());
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((instanceCode == null) ? 0 : instanceCode.hashCode());
		result = prime * result
				+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime
				* result
				+ ((parentStandardCodePicklist == null) ? 0
						: parentStandardCodePicklist.hashCode());
		result = prime * result
				+ ((standardCode == null) ? 0 : standardCode.hashCode());
		result = prime
				* result
				+ ((standardCodePicklistValue == null) ? 0
						: standardCodePicklistValue.hashCode());
		result = prime
				* result
				+ ((standardCodePicklistValues == null) ? 0
						: standardCodePicklistValues.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandardCodePicklist other = (StandardCodePicklist) obj;
		if (applicationGroup == null) {
			if (other.applicationGroup != null)
				return false;
		} else if (!applicationGroup.equals(other.applicationGroup))
			return false;
		if (applicationModule == null) {
			if (other.applicationModule != null)
				return false;
		} else if (!applicationModule.equals(other.applicationModule))
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (displayOrder == null) {
			if (other.displayOrder != null)
				return false;
		} else if (!displayOrder.equals(other.displayOrder))
			return false;
		if (effectiveEndDate == null) {
			if (other.effectiveEndDate != null)
				return false;
		} else if (!effectiveEndDate.equals(other.effectiveEndDate))
			return false;
		if (effectiveStartDate == null) {
			if (other.effectiveStartDate != null)
				return false;
		} else if (!effectiveStartDate.equals(other.effectiveStartDate))
			return false;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instanceCode == null) {
			if (other.instanceCode != null)
				return false;
		} else if (!instanceCode.equals(other.instanceCode))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedOn == null) {
			if (other.modifiedOn != null)
				return false;
		} else if (!modifiedOn.equals(other.modifiedOn))
			return false;
		if (parentStandardCodePicklist == null) {
			if (other.parentStandardCodePicklist != null)
				return false;
		} else if (!parentStandardCodePicklist
				.equals(other.parentStandardCodePicklist))
			return false;
		if (standardCode == null) {
			if (other.standardCode != null)
				return false;
		} else if (!standardCode.equals(other.standardCode))
			return false;
		if (standardCodePicklistValue == null) {
			if (other.standardCodePicklistValue != null)
				return false;
		} else if (!standardCodePicklistValue
				.equals(other.standardCodePicklistValue))
			return false;
		if (standardCodePicklistValues == null) {
			if (other.standardCodePicklistValues != null)
				return false;
		} else if (!standardCodePicklistValues
				.equals(other.standardCodePicklistValues))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}