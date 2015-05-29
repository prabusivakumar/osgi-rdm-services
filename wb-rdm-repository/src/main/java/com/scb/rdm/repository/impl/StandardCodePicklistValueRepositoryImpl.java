package com.scb.rdm.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.StandardCodePicklistValue;
import com.scb.rdm.repository.StandardCodePicklistValueRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class StandardCodePicklistValueRepositoryImpl extends
		GenericCrudRepositoryImpl<StandardCodePicklistValue, BigDecimal>
		implements StandardCodePicklistValueRepository {

	private EntityManager entityManager;

	public void init() {
		System.out
				.println("StandardCodePicklistValueRepositoryImpl Initialized Code Id: 17");
		final Iterable<StandardCodePicklistValue> standardCodePicklist = this
				.findByCodeIdAndCodeValue("17", "1303");
		if (standardCodePicklist.iterator().hasNext()) {
			System.out
					.println("StandardCodePicklistValueRepositoryImpl has some value");
			System.out.println(standardCodePicklist.iterator().next()
					.getCodeId());
		}
	}

	@Override
	public Iterable<StandardCodePicklistValue> findByCodeIdAndCodeValue(
			String codeId, String codeValue) {
		@SuppressWarnings("unchecked")
		Iterable<StandardCodePicklistValue> standardCodePicklistResult = entityManager
				.createNamedQuery("findByCodeIdAndCodeValuePV")
				.setParameter(1, codeId).setParameter(2, codeValue)
				.getResultList();
		return standardCodePicklistResult;
	}

	@Override
	public Iterable<StandardCodePicklistValue> findByCodeId(String codeId) {
		@SuppressWarnings("unchecked")
		Iterable<StandardCodePicklistValue> standardCodePicklistResult = entityManager
				.createNamedQuery("findByCodeIdPV").setParameter(1, codeId)
				.getResultList();
		return standardCodePicklistResult;
	}

	public void setEntityManager(EntityManager entityManager) {
		System.out
				.println("Setting EntityManager in StandardCodePicklistValueRepositoryImpl : "
						+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
