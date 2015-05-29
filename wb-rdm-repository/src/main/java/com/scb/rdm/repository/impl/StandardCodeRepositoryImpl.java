package com.scb.rdm.repository.impl;

import javax.persistence.EntityManager;

import com.scb.rdm.entity.StandardCode;
import com.scb.rdm.repository.StandardCodeRepository;
import com.scb.wb.generic.repository.impl.GenericCrudRepositoryImpl;

public class StandardCodeRepositoryImpl extends
		GenericCrudRepositoryImpl<StandardCode, String> implements
		StandardCodeRepository {

	private EntityManager entityManager;

	public void init() {
		System.out.println("StandardCodeRepositoryImpl Initialized");
	}

	public void setEntityManager(EntityManager entityManager) {
		System.out
				.println("Setting EntityManager in StandardCodeRepositoryImpl : "
						+ entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
