package com.scb.rdm.repository.impl;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.entity.id.CurrencyKey;
import com.scb.rdm.repository.CurrencyRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class CurrencyRepositoryImpl extends
		GenericCrudRepositoryImpl<CurrencyCode, CurrencyKey> implements
		CurrencyRepository {

	private EntityManager entityManager;
	
	public void init() {
		System.out.println("CurrencyRepositoryImpl Initialized Currency Code: CNY");
		final CurrencyCode currencyCode = this.findByCurrencyCode("CNY");
		System.out.println("CountryCodeDescription "
				+ currencyCode.getCountryCodeDescription());
		System.out.println("CurrencyCodeDescription "
				+ currencyCode.getCurrencyCodeDescription());

	}

	@Override
	public CurrencyCode findByCurrencyCode(String currencyCode) {
		CurrencyCode currencyCodeResult = (CurrencyCode) entityManager
				.createNamedQuery(
						"findByCurrencyCode")
				.setParameter(1, currencyCode).getSingleResult();
		return currencyCodeResult;
	}

	public void setEntityManager(EntityManager entityManager) {
		System.out.println("Setting EntityManager in CurrencyRepositoryImpl : "
				+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
