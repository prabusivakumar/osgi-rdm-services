package com.scb.rdm.repository;

import com.scb.rdm.entity.StandardCodePicklistValue;

public interface StandardCodePicklistValueRepository {

	Iterable<StandardCodePicklistValue> findByCodeIdAndCodeValue(String codeId,
			String codeValue);

	Iterable<StandardCodePicklistValue> findByCodeId(String codeId);

}