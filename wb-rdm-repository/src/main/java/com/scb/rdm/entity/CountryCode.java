package com.scb.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.scb.rdm.type.Status;

/**
 * The Country Entity
 * 
 * @author 1434190
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findByCountryCode", query = "select e from CountryCode e where e.countryCode = ?1"),
		@NamedQuery(name = "findByInternalCountryRegionCodeAndStatus", query = "select e from CountryCode e where e.internalCountryRegionCode = ?1 and e.status = ?2") })
@Table(name = "COUNTRY_CODE")
public class CountryCode implements Serializable {

	/** Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COUNTRY_CODE", length = 24)
	private String countryCode;
	
	@Column(name = "VERSION")
	private Integer version;

	@Column(name = "COUNTRY_DESC", length = 500)
	private String countryCodeDescription;

	@Column(name = "INTERNAL_REGION_CODE", length = 20)
	private String internalCountryRegionCode;

	@Column(name = "INTERNAL_REGION_DESC", length = 500)
	private String internalCountryRegionDescription;

	@Column(name = "ISO_INDICATOR", length = 3)
	private String isoIndicator;

	@Column(name = "ISO_ALPHA2_COUNTRY_CODE", length = 2)
	private String isoAlpha2CountryCode;

	@Column(name = "ISO_ALPHA3_COUNTRY_CODE", length = 3)
	private String isoAlpha3CountryCode;

	@Column(name = "ISO_NUMERIC_CODE", length = 3)
	private String isoNumericCode;

	@Column(name = "NPC_INDICATOR", length = 3)
	private String npcIndicator;

	@Column(name = "CALENDAR_TYPE_CODE", length = 20)
	private String calendarTypeCode;

	@Column(name = "HEMISPHERE_CODE", length = 20)
	private String hemisphereCode;

	@Column(name = "HEMISPHERE_DESC", length = 500)
	private String hemisphereDescription;

	@Column(name = "REFERENCE_TABLE_ID", length = 64)
	private String referenceTableId;

	@Column(name = "EFFECTIVE_START_DATE")
	private Date effectiveStartDate;

	@Column(name = "EFFECTIVE_END_DATE")
	private Date effectiveEndDate;

	@Column(name = "ENTITY_STATE", length = 25)
	private String entityState;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;

	@Column(name = "SOURCE_ID", length = 20)
	private String sourceId;

	@Column(name = "STATUS", length = 20)
	@Enumerated(EnumType.STRING)
	private Status status;

	public CountryCode() {
		
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
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the countryCodeDescription
	 */
	public String getCountryCodeDescription() {
		return countryCodeDescription;
	}

	/**
	 * @param countryCodeDescription
	 *            the countryCodeDescription to set
	 */
	public void setCountryCodeDescription(String countryCodeDescription) {
		this.countryCodeDescription = countryCodeDescription;
	}

	/**
	 * @return the internalCountryRegionCode
	 */
	public String getInternalCountryRegionCode() {
		return internalCountryRegionCode;
	}

	/**
	 * @param internalCountryRegionCode
	 *            the internalCountryRegionCode to set
	 */
	public void setInternalCountryRegionCode(String internalCountryRegionCode) {
		this.internalCountryRegionCode = internalCountryRegionCode;
	}

	/**
	 * @return the internalCountryRegionDescription
	 */
	public String getInternalCountryRegionDescription() {
		return internalCountryRegionDescription;
	}

	/**
	 * @param internalCountryRegionDescription
	 *            the internalCountryRegionDescription to set
	 */
	public void setInternalCountryRegionDescription(
			String internalCountryRegionDescription) {
		this.internalCountryRegionDescription = internalCountryRegionDescription;
	}

	/**
	 * @return the isoIndicator
	 */
	public String getIsoIndicator() {
		return isoIndicator;
	}

	/**
	 * @param isoIndicator
	 *            the isoIndicator to set
	 */
	public void setIsoIndicator(String isoIndicator) {
		this.isoIndicator = isoIndicator;
	}

	/**
	 * @return the isoAlpha2CountryCode
	 */
	public String getIsoAlpha2CountryCode() {
		return isoAlpha2CountryCode;
	}

	/**
	 * @param isoAlpha2CountryCode
	 *            the isoAlpha2CountryCode to set
	 */
	public void setIsoAlpha2CountryCode(String isoAlpha2CountryCode) {
		this.isoAlpha2CountryCode = isoAlpha2CountryCode;
	}

	/**
	 * @return the isoAlpha3CountryCode
	 */
	public String getIsoAlpha3CountryCode() {
		return isoAlpha3CountryCode;
	}

	/**
	 * @param isoAlpha3CountryCode
	 *            the isoAlpha3CountryCode to set
	 */
	public void setIsoAlpha3CountryCode(String isoAlpha3CountryCode) {
		this.isoAlpha3CountryCode = isoAlpha3CountryCode;
	}

	/**
	 * @return the isoNumericCode
	 */
	public String getIsoNumericCode() {
		return isoNumericCode;
	}

	/**
	 * @param isoNumericCode
	 *            the isoNumericCode to set
	 */
	public void setIsoNumericCode(String isoNumericCode) {
		this.isoNumericCode = isoNumericCode;
	}

	/**
	 * @return the npcIndicator
	 */
	public String getNpcIndicator() {
		return npcIndicator;
	}

	/**
	 * @param npcIndicator
	 *            the npcIndicator to set
	 */
	public void setNpcIndicator(String npcIndicator) {
		this.npcIndicator = npcIndicator;
	}

	/**
	 * @return the calendarTypeCode
	 */
	public String getCalendarTypeCode() {
		return calendarTypeCode;
	}

	/**
	 * @param calendarTypeCode
	 *            the calendarTypeCode to set
	 */
	public void setCalendarTypeCode(String calendarTypeCode) {
		this.calendarTypeCode = calendarTypeCode;
	}

	/**
	 * @return the hemisphereCode
	 */
	public String getHemisphereCode() {
		return hemisphereCode;
	}

	/**
	 * @param hemisphereCode
	 *            the hemisphereCode to set
	 */
	public void setHemisphereCode(String hemisphereCode) {
		this.hemisphereCode = hemisphereCode;
	}

	/**
	 * @return the hemisphereDescription
	 */
	public String getHemisphereDescription() {
		return hemisphereDescription;
	}

	/**
	 * @param hemisphereDescription
	 *            the hemisphereDescription to set
	 */
	public void setHemisphereDescription(String hemisphereDescription) {
		this.hemisphereDescription = hemisphereDescription;
	}

	/**
	 * @return the referenceTableId
	 */
	public String getReferenceTableId() {
		return referenceTableId;
	}

	/**
	 * @param referenceTableId
	 *            the referenceTableId to set
	 */
	public void setReferenceTableId(String referenceTableId) {
		this.referenceTableId = referenceTableId;
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
	 * @return the entityState
	 */
	public String getEntityState() {
		return entityState;
	}

	/**
	 * @param entityState
	 *            the entityState to set
	 */
	public void setEntityState(String entityState) {
		this.entityState = entityState;
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
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn
	 *            the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the sourceId
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId
	 *            the sourceId to set
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((calendarTypeCode == null) ? 0 : calendarTypeCode.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime
				* result
				+ ((countryCodeDescription == null) ? 0
						: countryCodeDescription.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime
				* result
				+ ((effectiveStartDate == null) ? 0 : effectiveStartDate
						.hashCode());
		result = prime * result
				+ ((entityState == null) ? 0 : entityState.hashCode());
		result = prime * result
				+ ((hemisphereCode == null) ? 0 : hemisphereCode.hashCode());
		result = prime
				* result
				+ ((hemisphereDescription == null) ? 0 : hemisphereDescription
						.hashCode());
		result = prime
				* result
				+ ((internalCountryRegionCode == null) ? 0
						: internalCountryRegionCode.hashCode());
		result = prime
				* result
				+ ((internalCountryRegionDescription == null) ? 0
						: internalCountryRegionDescription.hashCode());
		result = prime
				* result
				+ ((isoAlpha2CountryCode == null) ? 0 : isoAlpha2CountryCode
						.hashCode());
		result = prime
				* result
				+ ((isoAlpha3CountryCode == null) ? 0 : isoAlpha3CountryCode
						.hashCode());
		result = prime * result
				+ ((isoIndicator == null) ? 0 : isoIndicator.hashCode());
		result = prime * result
				+ ((isoNumericCode == null) ? 0 : isoNumericCode.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime * result
				+ ((npcIndicator == null) ? 0 : npcIndicator.hashCode());
		result = prime
				* result
				+ ((referenceTableId == null) ? 0 : referenceTableId.hashCode());
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		CountryCode other = (CountryCode) obj;
		if (calendarTypeCode == null) {
			if (other.calendarTypeCode != null)
				return false;
		} else if (!calendarTypeCode.equals(other.calendarTypeCode))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryCodeDescription == null) {
			if (other.countryCodeDescription != null)
				return false;
		} else if (!countryCodeDescription.equals(other.countryCodeDescription))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
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
		if (entityState == null) {
			if (other.entityState != null)
				return false;
		} else if (!entityState.equals(other.entityState))
			return false;
		if (hemisphereCode == null) {
			if (other.hemisphereCode != null)
				return false;
		} else if (!hemisphereCode.equals(other.hemisphereCode))
			return false;
		if (hemisphereDescription == null) {
			if (other.hemisphereDescription != null)
				return false;
		} else if (!hemisphereDescription.equals(other.hemisphereDescription))
			return false;
		if (internalCountryRegionCode == null) {
			if (other.internalCountryRegionCode != null)
				return false;
		} else if (!internalCountryRegionCode
				.equals(other.internalCountryRegionCode))
			return false;
		if (internalCountryRegionDescription == null) {
			if (other.internalCountryRegionDescription != null)
				return false;
		} else if (!internalCountryRegionDescription
				.equals(other.internalCountryRegionDescription))
			return false;
		if (isoAlpha2CountryCode == null) {
			if (other.isoAlpha2CountryCode != null)
				return false;
		} else if (!isoAlpha2CountryCode.equals(other.isoAlpha2CountryCode))
			return false;
		if (isoAlpha3CountryCode == null) {
			if (other.isoAlpha3CountryCode != null)
				return false;
		} else if (!isoAlpha3CountryCode.equals(other.isoAlpha3CountryCode))
			return false;
		if (isoIndicator == null) {
			if (other.isoIndicator != null)
				return false;
		} else if (!isoIndicator.equals(other.isoIndicator))
			return false;
		if (isoNumericCode == null) {
			if (other.isoNumericCode != null)
				return false;
		} else if (!isoNumericCode.equals(other.isoNumericCode))
			return false;
		if (modifiedOn == null) {
			if (other.modifiedOn != null)
				return false;
		} else if (!modifiedOn.equals(other.modifiedOn))
			return false;
		if (npcIndicator == null) {
			if (other.npcIndicator != null)
				return false;
		} else if (!npcIndicator.equals(other.npcIndicator))
			return false;
		if (referenceTableId == null) {
			if (other.referenceTableId != null)
				return false;
		} else if (!referenceTableId.equals(other.referenceTableId))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (status != other.status)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
