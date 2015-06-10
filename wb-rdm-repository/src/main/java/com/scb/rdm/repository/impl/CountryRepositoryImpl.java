package com.scb.rdm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.type.Status;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class CountryRepositoryImpl extends
		GenericCrudRepositoryImpl<CountryCode, String> implements
		CountryRepository {

	private EntityManager entityManager;

	public void init() {
		System.out.println("Country Repository Initialized");
		final CountryCode countryCode = this.findByCountryCode("HK");
		System.out.println("CountrycodeDescription is "
				+ countryCode.getCountryCodeDescription());
		System.out.println("HemisphereDescription is "
				+ countryCode.getHemisphereDescription());
		System.out
				.println("Executing findByInternalCountryRegionCodeAndStatus: ");
		List<CountryCode> countryCodeList = this
				.findByInternalCountryRegionCodeAndStatus("EUR", null);
		System.out.println("No. of records retrieved" + countryCodeList.size());
		for (CountryCode cc : countryCodeList) {
			System.out.println("CC with InternalCountryRegion as EUR"
					+ cc.getCountryCodeDescription());
		}
	}

	@Override
	public CountryCode findByCountryCode(String countryCode) {
		@SuppressWarnings("unchecked")
		List<CountryCode> countryCodeList = entityManager
				.createNamedQuery("findByCountryCode")
				.setParameter(1, countryCode).getResultList();
		if (countryCodeList != null && !countryCodeList.isEmpty())
			return countryCodeList.get(0);
		else
			return null;

	}

	@Override
	public List<CountryCode> findByInternalCountryRegionCodeAndStatus(
			String internalCountryRegionCode, Status status) {
		@SuppressWarnings("unchecked")
		List<CountryCode> countryCodeList = entityManager
				.createNamedQuery("findByInternalCountryRegionCodeAndStatus")
				.setParameter(1, internalCountryRegionCode)
				.setParameter(2, status).getResultList();

		return countryCodeList;
	}

	public void setEntityManager(EntityManager entityManager) {
		System.out.println("Setting EntityManager in CountryRepositoryImpl : "
				+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
