package com.scb.rdm;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.repository.impl.CountryRepositoryImpl;
import com.scb.rdm.repository.impl.CurrencyRepositoryImpl;

public class TestRepository {

	@InjectMocks
	private CountryRepositoryImpl counttryRepositoryImpl;

	@InjectMocks
	private CurrencyRepositoryImpl currencyRepositoryImpl;

	@Mock
	private EntityManager entityManager;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test case is used to test the Country Repository
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testCaseCountryRepository() throws Throwable {
		final Query queryMock = Mockito.mock(Query.class);
		final CountryCode countryCode = Mockito.mock(CountryCode.class);
		when(entityManager.createNamedQuery("findByCountryCode")).thenReturn(
				queryMock);
		when(queryMock.setParameter(1, "HK")).thenReturn(queryMock);
		List<CountryCode> resultList = new ArrayList<CountryCode>();
		resultList.add(countryCode);
		when(queryMock.getResultList()).thenReturn(resultList);
		CountryCode cd = this.counttryRepositoryImpl.findByCountryCode("HK");
		Assert.assertNotNull(cd);
	}

	/**
	 * This test case is used to test the Currency Repository.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testCaseCurrencyRepository() throws Throwable {
		final Query queryMock = Mockito.mock(Query.class);
		final CurrencyCode currencyCode = Mockito.mock(CurrencyCode.class);
		when(entityManager.createNamedQuery("findByCurrencyCode")).thenReturn(
				queryMock);
		when(queryMock.setParameter(1, "SGD")).thenReturn(queryMock);
		List<CurrencyCode> resultList = new ArrayList<CurrencyCode>();
		resultList.add(currencyCode);
		when(queryMock.getResultList()).thenReturn(resultList);
		CurrencyCode cd = this.currencyRepositoryImpl.findByCurrencyCode("SGD");
		Assert.assertNotNull(cd);
	}

}
