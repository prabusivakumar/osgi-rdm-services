package com.scb.rdm.camel.processor.standardCode;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.rdm.xml.standard.binding.PublishStandardCodesRequest;
import com.scb.rdm.xml.standard.binding.StandardCode;

public class PublishStandardCodeRequestProcessor implements Processor {

	private StandardCodePicklistRepository standardCodePicklistRepository;

	private StandardCodeTransformer standardCodeTransformer;

	private static final Logger LOG = LoggerFactory
			.getLogger(PublishStandardCodeRequestProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		List<StandardCodePicklist> entities = new ArrayList<StandardCodePicklist>();
		PublishStandardCodesRequest publishStandardCodesRequest = exchange
				.getIn().getBody(PublishStandardCodesRequest.class);
		List<StandardCode> standardCodes = publishStandardCodesRequest
				.getPublishStandardCodesReqPayload()
				.getPublishStandardCodesReq();
		for (StandardCode standardCode : standardCodes) {
			LOG.info("Processing the Standard Code for {}", standardCode
					.getStandardCodeInfo().getStdCodeDescription());
			StandardCodePicklist standardCodePicklistEntity = standardCodeTransformer
					.transform(standardCode.getStandardCodeInfo());
			if (standardCodePicklistEntity == null) {
				LOG.info("Entity is null. creating dummy object of Standard Code");
				standardCodePicklistEntity = new StandardCodePicklist();
			}
			LOG.info("Standard Code entity data: "
					+ standardCodePicklistEntity.getStandardCode().getCodeId());
			// merge(standardCodePicklistEntity, standardCode);
			entities.add(standardCodePicklistEntity);
		}
		this.standardCodePicklistRepository.save(entities);
		exchange.getOut().setBody(entities);

	}

	// private CurrencyKey getCurrencyCodeKey(Currency payload) {
	// String currencyCode = payload.getCurrencyInfo().getCurrencyCode();
	// String version = payload.getCurrencyInfo().getCurrencyCodeVersion();
	// CurrencyKey key = new CurrencyKey();
	// key.setCurrencyCode(currencyCode);
	// key.setVersion(Integer.valueOf(version));
	// return key;
	// }
	
	public StandardCodePicklistRepository getStandardCodePicklistRepository() {
		return standardCodePicklistRepository;
	}

	public void setStandardCodePicklistRepository(
			StandardCodePicklistRepository standardCodePicklistRepository) {
		this.standardCodePicklistRepository = standardCodePicklistRepository;
	}

	public StandardCodeTransformer getStandardCodeTransformer() {
		return standardCodeTransformer;
	}

	public void setStandardCodeTransformer(
			StandardCodeTransformer standardCodeTransformer) {
		this.standardCodeTransformer = standardCodeTransformer;
	}

}
