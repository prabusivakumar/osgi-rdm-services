package com.scb.rdm.repository;

import java.util.List;

import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.type.Status;
import com.scb.wb.generic.repository.GenericCrudRepository;

public interface CountryRepository extends GenericCrudRepository<CountryCode, String>{

	List<CountryCode> findByInternalCountryRegionCodeAndStatus(
			String internalCountryRegionCode, Status status);

	CountryCode findByCountryCode(String countryCode);
}