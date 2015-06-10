package com.scb.rdm.camel.processor.standardCode;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.StandardCode;
import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.entity.StandardCodePicklistValue;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.rdm.repository.StandardCodePicklistValueRepository;
import com.scb.rdm.type.StandardCodeType;
import com.scb.rdm.xml.standard.binding.StandardCodeInfoElement;

public class StandardCodeTransformer {

	private StandardCodePicklistRepository standardCodePicklistRepository;

	private StandardCodePicklistValueRepository standardCodePicklistValueRepository;

	private static final Logger LOG = LoggerFactory
			.getLogger(StandardCodeTransformer.class);

	// @Autowired
	// private PicklistSequenceIncrementer picklistSequenceIncrementer;
	//
	// @Autowired
	// private PicklistValueSequenceIncrementer
	// picklistValueSequenceIncrementer;

	public StandardCodePicklist transform(
			StandardCodeInfoElement standardCodeInfo) {
		StandardCode standardCode = new StandardCode();
		standardCode.setCodeId(standardCodeInfo.getStdCodeType());
		standardCode.setCodeDescription(standardCodeInfo
				.getStdCodeTypeDescription());
		LOG.info("Standard Code Id: " + standardCode.getCodeId());
		LOG.info("Standard Code Description: " + standardCode.getCodeDescription());
		StandardCodePicklist standardCodePicklist = new StandardCodePicklist();
		Iterable<StandardCodePicklist> entities = standardCodePicklistRepository
				.findByCodeIdAndCodeValue(standardCodeInfo.getStdCodeType(),
						standardCodeInfo.getStdCode());
		for (StandardCodePicklist entity : entities) {
			LOG.info("Fetching entities: " + entity.getId());
			LOG.info("Fetching entities: " + entity.getCodeValue());
			standardCodePicklist.setId(entity.getId());
			break;
		}
		// if (standardCodePicklist.getId() == null)
		// standardCodePicklist.setId(picklistSequenceIncrementer.getValue());
		if (standardCodeInfo.getParentStdCode() != null
				&& !StringUtils.isBlank(standardCodeInfo.getParentStdCode())) {
			StandardCodeType parentStandardCodeType = StandardCodeType.build(
					standardCodeInfo.getStdCodeType())
					.getParentStandardCodeType();
			if (parentStandardCodeType != null) {
				LOG.info("Parent standard code type: " + parentStandardCodeType.getCodeType());
				entities = standardCodePicklistRepository
						.findByCodeIdAndCodeValue(
								parentStandardCodeType.getCodeType(),
								standardCodeInfo.getParentStdCode());
				for (StandardCodePicklist entity : entities) {
					LOG.info("Fetching parent entities: " + entity.getId());
					LOG.info("Fetching parent entities: " + entity.getCodeValue());
					standardCodePicklist.setParentStandardCodePicklist(entity);
					break;
				}
			}
		}
		StandardCodePicklistValue standardCodePicklistValue = new StandardCodePicklistValue();
		Iterable<StandardCodePicklistValue> valueEntities = standardCodePicklistValueRepository
				.findByCodeIdAndCodeValue(standardCodeInfo.getStdCodeType(),
						standardCodeInfo.getStdCode());
		for (StandardCodePicklistValue entity : valueEntities) {
			LOG.info("Fetching Picklist value entities: " + entity.getId());
			LOG.info("Fetching Picklist value entities: " + entity.getCodeId());
			LOG.info("Fetching Picklist value entities: " + entity.getCodeValue());
			standardCodePicklistValue.setId(entity.getId());
			break;
		}
		// if (standardCodePicklistValue.getId() == null)
		// standardCodePicklistValue.setId(picklistValueSequenceIncrementer
		// .getValue());
		standardCodePicklistValue.setCodeId(standardCode.getCodeId());
		standardCodePicklistValue.setCodeValue(standardCodePicklist
				.getCodeValue());
		standardCodePicklistValue.setShortDescription(standardCodeInfo
				.getStdCodeDescription());
		standardCodePicklistValue.setLongDescription(standardCodeInfo
				.getStdCodeDefinition());
		standardCodePicklist
				.setStandardCodePicklistValue(standardCodePicklistValue);
		standardCodePicklist.setStandardCode(standardCode);
		return standardCodePicklist;
	}

	public StandardCodePicklistRepository getStandardCodePicklistRepository() {
		return standardCodePicklistRepository;
	}

	public void setStandardCodePicklistRepository(
			StandardCodePicklistRepository standardCodePicklistRepository) {
		this.standardCodePicklistRepository = standardCodePicklistRepository;
	}

	public StandardCodePicklistValueRepository getStandardCodePicklistValueRepository() {
		return standardCodePicklistValueRepository;
	}

	public void setStandardCodePicklistValueRepository(
			StandardCodePicklistValueRepository standardCodePicklistValueRepository) {
		this.standardCodePicklistValueRepository = standardCodePicklistValueRepository;
	}

}
