package com.scb.rdm.repository.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.InterfaceMessage;
import com.scb.rdm.repository.InterfaceMessageRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class InterfaceMessageRepositoryImpl extends
		GenericCrudRepositoryImpl<InterfaceMessage, BigDecimal> implements
		InterfaceMessageRepository {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		System.out
				.println("Setting EntityManager in InterfaceMessageRepositoryImpl : "
						+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
