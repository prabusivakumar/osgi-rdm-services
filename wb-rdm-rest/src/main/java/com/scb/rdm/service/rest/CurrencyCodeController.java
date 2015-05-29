package com.scb.rdm.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.repository.CurrencyRepository;

/**
 * JAX-RS REST API for the Reference Data Management Service to fetch Currency
 * Code.
 * 
 * @author Swati Gupta
 * 
 */
@Path("/currencyCode")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyCodeController {

	private static final Logger LOG = LoggerFactory
			.getLogger(CurrencyCodeController.class);

	private CurrencyRepository currencyRepository;

	public CurrencyRepository getCurrencyRepository() {
		return currencyRepository;
	}

	public void setCurrencyRepository(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	/**
	 * GET API to fetch all the Currencies.
	 * 
	 * @return
	 */
	@GET
	// @Path("/get")
	public Iterable<CurrencyCode> getCurrencyCode() {
		try {
			return getCurrencyRepository().findAll();
		} catch (ClassNotFoundException e) {
			LOG.error("Exception in fetch", e);
		}
		return null;
	}

	/**
	 * GET API to fetch the Currency by currency code.
	 * 
	 * @return
	 */
	@GET
	@Path("/{id}")
	public CurrencyCode getCurrencyCode(@PathParam("id") String currencyCode) {
		System.out.println("Currency Code is: " + currencyCode);
		LOG.info("Currency Code is: " + currencyCode);
		return getCurrencyRepository().findByCurrencyCode(currencyCode);
	}

}
