package com.scb.rdm.repository;

import java.math.BigDecimal;

import com.scb.wb.generic.repository.GenericCrudRepository;
import com.scb.rdm.entity.StandardCodePicklist;

public interface StandardCodePicklistRepository  extends GenericCrudRepository<StandardCodePicklist, BigDecimal> {

	public abstract Iterable<StandardCodePicklist> findByCodeIdAndCodeValue(String paramString1, String paramString2);

	public abstract Iterable<StandardCodePicklist> findByCodeId(String paramString);
}
