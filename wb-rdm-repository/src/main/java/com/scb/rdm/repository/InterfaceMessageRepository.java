package com.scb.rdm.repository;

import java.math.BigDecimal;

import com.scb.rdm.entity.InterfaceMessage;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface InterfaceMessageRepository extends
		GenericCrudRepository<InterfaceMessage, BigDecimal> {

}