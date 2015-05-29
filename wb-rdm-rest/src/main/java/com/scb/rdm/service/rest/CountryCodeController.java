package com.scb.rdm.service.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.type.Status;

/**
 * JAX-RS REST API for the Reference Data Management Service to fetch CountryCode.
 * 
 * @author Swati Gupta
 * 
 */
@Path("/countryCode")
@Produces(MediaType.APPLICATION_JSON)
public class CountryCodeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CountryCodeController.class);

	private CountryRepository countryRepository;

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	/**
	 * GET API to fetch all the Countries.
	 * 
	 * @return
	 */
	@GET
	//@Path("/get")
	public Iterable<CountryCode> getCountryCode() {
		try {
			LOG.info("Getting Country Code: ");
			return getCountryRepository().findAll();
		} catch (ClassNotFoundException e) {
			LOG.error("Exception in fetch", e);
		}
		return null;
	}

	/**
	 * GET API to fetch the Country by country code.
	 * 
	 * @return
	 */
	@GET
	@Path("/{id}")
	public CountryCode getCountryByCountryCode(
			@PathParam("id") String countryCode) {
		System.out.println("Country Code is: " + countryCode);
		LOG.info("Country Code is: " + countryCode);
		return getCountryRepository().findByCountryCode(countryCode);
	}

	/**
	 * GET API to fetch the Country by country code.
	 * 
	 * @return
	 */
	@GET
	@Path("/{internalCountryRegionCode}/{status}")
	public List<CountryCode> getCountryByCountryCode(
			@PathParam("internalCountryRegionCode") String internalCountryRegionCode,
			@PathParam("status") Status status) {
		return getCountryRepository().findByInternalCountryRegionCodeAndStatus(
				internalCountryRegionCode, status);
	}

}
