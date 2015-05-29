package com.scb.rdm;

import static org.mockito.Mockito.when;

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
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.repository.impl.CountryRepositoryImpl;

public class TestRepository {

	@Mock
	private CountryRepository countryRepository;

	
	@InjectMocks
	private CountryRepositoryImpl counttryRepositoryImpl;
	
	@Mock
	private EntityManager entityManager;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test case is used to test when there is an exception occured during
	 * commit.
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
		when(queryMock.getSingleResult()).thenReturn(countryCode);
		CountryCode cd = this.counttryRepositoryImpl.findByCountryCode("HK");
		Assert.assertNotNull(cd);
	}

	// /**
	// * This test is used to check the success scenario where a Platform
	// * Transaction Manager is null. This will result in Committing the
	// * transaction.
	// *
	// * @throws NoSuchMethodException
	// * @throws SecurityException
	// */
	//
	// @Test
	// public void testCasePlatFormTxnMgrNull() throws NoSuchMethodException,
	// SecurityException {
	// // platformTransactionManager = null;
	// final MethodSignature signature = Mockito.mock(MethodSignature.class);
	// final PlatformTransactionManager platformTransactionManager = Mockito
	// .mock(PlatformTransactionManager.class);
	// final Method method = TransactionTest.class.getMethod("add", null);
	// when(proceedingJoinPoint.getSignature()).thenReturn(signature);
	// when(signature.getName()).thenReturn("persist");
	// when(signature.getMethod()).thenReturn(method);
	// when(
	// serviceLocator
	// .getServiceReference(PlatformTransactionManager.class))
	// .thenReturn(platformTransactionManager);
	// final Object object = this.transactionalAspect
	// .execute(proceedingJoinPoint);
	// Assert.assertNull(object);
	// }
	//
	// public static class TransactionTest {
	//
	// @TransactionalContext(propagation = Propagation.REQUIRED)
	// public void add() {
	//
	// }
	// }

}
