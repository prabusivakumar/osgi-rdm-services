package com.scb.rdm.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.rdm.type.StandardCodeType;

/**
 * JAX-RS REST API for the Reference Data Management Service to fetch Standard
 * Code.
 * 
 * @author Swati Gupta
 * 
 */
@Path("/standardCode")
@Produces(MediaType.APPLICATION_JSON)
public class StandardCodeController {

	private static final Logger LOG = LoggerFactory
			.getLogger(StandardCodeController.class);

	private StandardCodePicklistRepository standardCodePicklistRepository;

	public StandardCodePicklistRepository getStandardCodePicklistRepository() {
		return standardCodePicklistRepository;
	}

	public void setStandardCodePicklistRepository(
			StandardCodePicklistRepository standardCodePicklistRepository) {
		this.standardCodePicklistRepository = standardCodePicklistRepository;
	}

	/**
	 * GET API to fetch the Customer Segment Code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerSegmentCode")
	public Iterable<StandardCodePicklist> getCustomerSegmentCode() {
		LOG.info("Inside getCustomerSegmentCode ");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.SEGMENT_CODE.getCodeType());

	}

	/**
	 * GET API to fetch the Customer Sub Segment code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerSubSegmentCode")
	public Iterable<StandardCodePicklist> getCustomerSubSegmentCode() {		
		LOG.info("Inside getCustomerSubSegmentCode ");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.SUBSEGMENT_CODE.getCodeType());
	}

	/**
	 * GET API to fetch the Customer ISIC code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerIsicCode")
	public Iterable<StandardCodePicklist> getCustomerIsicCode() {		
		LOG.info("Inside getCustomerIsicCode");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.ISIC_CODE.getCodeType());
	}

	/**
	 * GET API to fetch the Customer Legal Constitution code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerLegalConstitutionCode")
	public Iterable<StandardCodePicklist> getCustomerLegalConstitutionCode() {		
		LOG.info("Inside getCustomerLegalConstitutionCode");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.LEGAL_CONSTITUTION_CODE.getCodeType());
	}

	/**
	 * GET API to fetch the Customer Basel Segment code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerBaselSegmentCode")
	public Iterable<StandardCodePicklist> getCustomerBaselSegmentCode() {		
		LOG.info("Inside getCustomerBaselSegmentCode");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.BASEL_SEGMENT_CODE.getCodeType());
	}

	/**
	 * GET API to fetch the Customer BAsel Sub Segment code.
	 * 
	 * @return
	 */
	@GET
	@Path("/getCustomerBaselSubSegmentCode")
	public Iterable<StandardCodePicklist> getCustomerBaselSubSegmentCode() {		
		LOG.info("Inside getCustomerBaselSubSegmentCode");
		return getStandardCodePicklistRepository().findByCodeId(
				StandardCodeType.BASEL_SUBSEGMENT_CODE.getCodeType());
	}

}
