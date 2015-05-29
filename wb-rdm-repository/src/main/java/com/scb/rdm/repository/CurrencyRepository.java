package com.scb.rdm.repository;

import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.entity.id.CurrencyKey;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface CurrencyRepository extends GenericCrudRepository<CurrencyCode, CurrencyKey>{

	CurrencyCode findByCurrencyCode(String currencyCode);
}
