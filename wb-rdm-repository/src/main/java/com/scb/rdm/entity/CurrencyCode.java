package com.scb.rdm.entity;

import com.scb.rdm.entity.id.CurrencyKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Currency Code Entity holds the fields required to map the Currency Code in
 * the RDM Services.
 * 
 * @author Vijaykumar Dhandapani
 * @since 30-Jan-15
 */
@Entity
@NamedQuery(name = "findByCurrencyCode", query = "select e from CurrencyCode e where e.currencyCode = ?1")
@Table(name = "CURRENCY_CODE")
public class CurrencyCode implements Serializable {

	/** Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CURRENCY_CODE", length = 24)
	private String currencyCode;

	@Column(name = "VERSION")
	private Integer version;	

	@Column(name = "CURRENCY_DESC", length = 500)
	private String currencyCodeDescription;

	@Column(name = "ISO_ALPHA3_CURRENCY_CODE", length = 3)
	private String isoAlpha3CurrencyCode;

	@Column(name = "ISO_CODE_INDICATOR", length = 3)
	private String isoCodeIndicator;

	@Column(name = "ISO_NUMERIC_CODE", length = 3)
	private String isoNumericCode;

	@Column(name = "PSGL_CURRENCY_INDICATOR")
	private String psglCurrencyIndicator;

	@Column(name = "ARCHILLES_EXCHANGE_RATE_IND", length = 3)
	private String achillesExchangeRateIndicator;

	@Column(name = "COUNTRY_CODE", length = 20)
	private String countryCode;

	@Column(name = "COUNTRY_DESC", length = 500)
	private String countryCodeDescription;

	@Column(name = "EXCHANGE_RATE_DENOMINATION")
	private String exchangeRateDenomination;

	@Column(name = "ROUNDING_DECIMAL_PLACE")
	private String currencyRoundingDecimalPlace;

	@Column(name = "REFERENCE_TABLE_ID", length = 64)
	private String referenceTableId;

	@Column(name = "EFFECTIVE_START_DATE")
	private Date effectiveStartDate;

	@Column(name = "EFFECTIVE_END_DATE")
	private Date effectiveEndDate;

	@Column(name = "ENTITY_STATE", length = 25)
	private String entityState;

	@Column(name = "CREATED_TIME_STAMP")
	private Date createdTimeStamp;

	@Column(name = "MODIFIED_TIME_STAMP")
	private Date modifiedTimeStamp;

	@Column(name = "SOURCE_ID", length = 20)
	private String sourceId;

	public CurrencyCode() {		
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
	 * @return the currencyCodeDescription
	 */
	public String getCurrencyCodeDescription() {
		return currencyCodeDescription;
	}

	/**
	 * @param currencyCodeDescription
	 *            the currencyCodeDescription to set
	 */
	public void setCurrencyCodeDescription(String currencyCodeDescription) {
		this.currencyCodeDescription = currencyCodeDescription;
	}

	/**
	 * @return the isoAlpha3CurrencyCode
	 */
	public String getIsoAlpha3CurrencyCode() {
		return isoAlpha3CurrencyCode;
	}

	/**
	 * @param isoAlpha3CurrencyCode
	 *            the isoAlpha3CurrencyCode to set
	 */
	public void setIsoAlpha3CurrencyCode(String isoAlpha3CurrencyCode) {
		this.isoAlpha3CurrencyCode = isoAlpha3CurrencyCode;
	}

	/**
	 * @return the isoCodeIndicator
	 */
	public String getIsoCodeIndicator() {
		return isoCodeIndicator;
	}

	/**
	 * @param isoCodeIndicator
	 *            the isoCodeIndicator to set
	 */
	public void setIsoCodeIndicator(String isoCodeIndicator) {
		this.isoCodeIndicator = isoCodeIndicator;
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
	 * @return the psglCurrencyIndicator
	 */
	public String getPsglCurrencyIndicator() {
		return psglCurrencyIndicator;
	}

	/**
	 * @param psglCurrencyIndicator
	 *            the psglCurrencyIndicator to set
	 */
	public void setPsglCurrencyIndicator(String psglCurrencyIndicator) {
		this.psglCurrencyIndicator = psglCurrencyIndicator;
	}

	/**
	 * @return the achillesExchangeRateIndicator
	 */
	public String getAchillesExchangeRateIndicator() {
		return achillesExchangeRateIndicator;
	}

	/**
	 * @param achillesExchangeRateIndicator
	 *            the achillesExchangeRateIndicator to set
	 */
	public void setAchillesExchangeRateIndicator(String achillesExchangeRateIndicator) {
		this.achillesExchangeRateIndicator = achillesExchangeRateIndicator;
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
	 * @return the exchangeRateDenomination
	 */
	public String getExchangeRateDenomination() {
		return exchangeRateDenomination;
	}

	/**
	 * @param exchangeRateDenomination
	 *            the exchangeRateDenomination to set
	 */
	public void setExchangeRateDenomination(String exchangeRateDenomination) {
		this.exchangeRateDenomination = exchangeRateDenomination;
	}

	/**
	 * @return the currencyRoundingDecimalPlace
	 */
	public String getCurrencyRoundingDecimalPlace() {
		return currencyRoundingDecimalPlace;
	}

	/**
	 * @param currencyRoundingDecimalPlace
	 *            the currencyRoundingDecimalPlace to set
	 */
	public void setCurrencyRoundingDecimalPlace(String currencyRoundingDecimalPlace) {
		this.currencyRoundingDecimalPlace = currencyRoundingDecimalPlace;
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
	 * @return the createdTimeStamp
	 */
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * @param createdTimeStamp
	 *            the createdTimeStamp to set
	 */
	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	/**
	 * @return the modifiedTimeStamp
	 */
	public Date getModifiedTimeStamp() {
		return modifiedTimeStamp;
	}

	/**
	 * @param modifiedTimeStamp
	 *            the modifiedTimeStamp to set
	 */
	public void setModifiedTimeStamp(Date modifiedTimeStamp) {
		this.modifiedTimeStamp = modifiedTimeStamp;
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((achillesExchangeRateIndicator == null) ? 0
						: achillesExchangeRateIndicator.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime
				* result
				+ ((countryCodeDescription == null) ? 0
						: countryCodeDescription.hashCode());
		result = prime
				* result
				+ ((createdTimeStamp == null) ? 0 : createdTimeStamp.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime
				* result
				+ ((currencyCodeDescription == null) ? 0
						: currencyCodeDescription.hashCode());
		result = prime
				* result
				+ ((currencyRoundingDecimalPlace == null) ? 0
						: currencyRoundingDecimalPlace.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime
				* result
				+ ((effectiveStartDate == null) ? 0 : effectiveStartDate
						.hashCode());
		result = prime * result
				+ ((entityState == null) ? 0 : entityState.hashCode());
		result = prime
				* result
				+ ((exchangeRateDenomination == null) ? 0
						: exchangeRateDenomination.hashCode());
		result = prime
				* result
				+ ((isoAlpha3CurrencyCode == null) ? 0 : isoAlpha3CurrencyCode
						.hashCode());
		result = prime
				* result
				+ ((isoCodeIndicator == null) ? 0 : isoCodeIndicator.hashCode());
		result = prime * result
				+ ((isoNumericCode == null) ? 0 : isoNumericCode.hashCode());
		result = prime
				* result
				+ ((modifiedTimeStamp == null) ? 0 : modifiedTimeStamp
						.hashCode());
		result = prime
				* result
				+ ((psglCurrencyIndicator == null) ? 0 : psglCurrencyIndicator
						.hashCode());
		result = prime
				* result
				+ ((referenceTableId == null) ? 0 : referenceTableId.hashCode());
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
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
		CurrencyCode other = (CurrencyCode) obj;
		if (achillesExchangeRateIndicator == null) {
			if (other.achillesExchangeRateIndicator != null)
				return false;
		} else if (!achillesExchangeRateIndicator
				.equals(other.achillesExchangeRateIndicator))
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
		if (createdTimeStamp == null) {
			if (other.createdTimeStamp != null)
				return false;
		} else if (!createdTimeStamp.equals(other.createdTimeStamp))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (currencyCodeDescription == null) {
			if (other.currencyCodeDescription != null)
				return false;
		} else if (!currencyCodeDescription
				.equals(other.currencyCodeDescription))
			return false;
		if (currencyRoundingDecimalPlace == null) {
			if (other.currencyRoundingDecimalPlace != null)
				return false;
		} else if (!currencyRoundingDecimalPlace
				.equals(other.currencyRoundingDecimalPlace))
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
		if (exchangeRateDenomination == null) {
			if (other.exchangeRateDenomination != null)
				return false;
		} else if (!exchangeRateDenomination
				.equals(other.exchangeRateDenomination))
			return false;
		if (isoAlpha3CurrencyCode == null) {
			if (other.isoAlpha3CurrencyCode != null)
				return false;
		} else if (!isoAlpha3CurrencyCode.equals(other.isoAlpha3CurrencyCode))
			return false;
		if (isoCodeIndicator == null) {
			if (other.isoCodeIndicator != null)
				return false;
		} else if (!isoCodeIndicator.equals(other.isoCodeIndicator))
			return false;
		if (isoNumericCode == null) {
			if (other.isoNumericCode != null)
				return false;
		} else if (!isoNumericCode.equals(other.isoNumericCode))
			return false;
		if (modifiedTimeStamp == null) {
			if (other.modifiedTimeStamp != null)
				return false;
		} else if (!modifiedTimeStamp.equals(other.modifiedTimeStamp))
			return false;
		if (psglCurrencyIndicator == null) {
			if (other.psglCurrencyIndicator != null)
				return false;
		} else if (!psglCurrencyIndicator.equals(other.psglCurrencyIndicator))
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
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	

}
