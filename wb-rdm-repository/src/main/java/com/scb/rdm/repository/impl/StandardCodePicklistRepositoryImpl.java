package com.scb.rdm.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class StandardCodePicklistRepositoryImpl extends
		GenericCrudRepositoryImpl<StandardCodePicklist, BigDecimal> implements
		StandardCodePicklistRepository {

	private EntityManager entityManager;

	public void init() {
		System.out
				.println("StandardCodePicklistRepositoryImpl Initialized Code Id: 17");
		final Iterable<StandardCodePicklist> standardCodePicklist = this
				.findByCodeIdAndCodeValue("17", "1303");
		if(standardCodePicklist.iterator().hasNext())
		{
			System.out.println("StandardCodePicklist has some value");
			System.out.println(standardCodePicklist.iterator().next().getCodeValue());
		}
	}

	@Override
	public Iterable<StandardCodePicklist> findByCodeIdAndCodeValue(
			String paramString1, String paramString2) {
		@SuppressWarnings("unchecked")
		Iterable<StandardCodePicklist> standardCodePicklistResult = entityManager
				.createNamedQuery("findByCodeIdAndCodeValue")
				.setParameter(1, paramString1).setParameter(2, paramString2)
				.getResultList();
		return standardCodePicklistResult;
	}

	@Override
	public Iterable<StandardCodePicklist> findByCodeId(String paramString) {
		@SuppressWarnings("unchecked")
		Iterable<StandardCodePicklist> standardCodePicklistResult = entityManager
				.createNamedQuery("findByCodeId").setParameter(1, paramString)
				.getResultList();
		return standardCodePicklistResult;
	}

	public void setEntityManager(EntityManager entityManager) {
		System.out
				.println("Setting EntityManager in StandardCodePicklistRepositoryImpl : "
						+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
