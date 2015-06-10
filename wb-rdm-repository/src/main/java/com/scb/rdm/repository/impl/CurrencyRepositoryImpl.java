package com.scb.rdm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.repository.CurrencyRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class CurrencyRepositoryImpl extends
		GenericCrudRepositoryImpl<CurrencyCode, String> implements
		CurrencyRepository {

	private EntityManager entityManager;

	public void init() {
		System.out
				.println("CurrencyRepositoryImpl Initialized Currency Code: CNY");
		final CurrencyCode currencyCode = this.findByCurrencyCode("CNY");
		System.out.println("CountryCodeDescription "
				+ currencyCode.getCountryCodeDescription());
		System.out.println("CurrencyCodeDescription "
				+ currencyCode.getCurrencyCodeDescription());

	}

	@Override
	public CurrencyCode findByCurrencyCode(String currencyCode) {
		@SuppressWarnings("unchecked")
		List<CurrencyCode> currencyCodeList = entityManager
				.createNamedQuery("findByCurrencyCode")
				.setParameter(1, currencyCode).getResultList();
		if (currencyCodeList != null && !currencyCodeList.isEmpty())
			return currencyCodeList.get(0);
		else
			return null;

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
