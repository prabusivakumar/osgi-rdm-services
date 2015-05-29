package com.scb.rdm.repository;

import java.math.BigDecimal;

//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.repository.CrudRepository;

import com.scb.rdm.entity.StandardCodePicklist;

public interface StandardCodePicklistRepository  {

	public abstract Iterable<StandardCodePicklist> findByCodeIdAndCodeValue(String paramString1, String paramString2);

	public abstract Iterable<StandardCodePicklist> findByCodeId(String paramString);
}
