package com.scb.rdm.camel.processor.country;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.xml.country.binding.Country;
import com.scb.rdm.xml.country.binding.CountryInfoElement;
import com.scb.rdm.xml.country.binding.PublishCountryRequest;

public class PublishCountryCodeRequestProcessor implements Processor {

	private CountryRepository countryRepository;

	private static final Logger LOG = LoggerFactory
			.getLogger(PublishCountryCodeRequestProcessor.class);

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		List<CountryCode> entities = new ArrayList<CountryCode>();
		PublishCountryRequest publishCountryRequest = exchange.getIn().getBody(
				PublishCountryRequest.class);
		for (Country country : publishCountryRequest
				.getPublishCountryReqPayload().getPublishCountryReq()) {
			// CountryCode entity =
			// this.countryRepository.findOne(getCountryCodeKey(country));
			CountryCode entity = this.countryRepository
					.findByCountryCode(country.getCountryInfo()
							.getCountryCode());
			if (entity == null) {
				LOG.info("Entity is null. creating dummy object of Country Code");
				System.out
						.println("Entity is null. creating dummy object of Country Code");
				entity = new CountryCode();
			}
			LOG.info("Country Code entity data: " + entity.getCountryCode());
			System.out.println("Country Code entity data: "
					+ entity.getCountryCode());
			LOG.info("Country Code entity data: " + entity.getVersion());
			System.out.println("Country Code entity data: "
					+ entity.getVersion());
			merge(entity, country);
			entities.add(entity);
		}
		this.countryRepository.save(entities);
		exchange.getOut().setBody(entities);
	}

	private void merge(CountryCode entity, Country payload) {
		CountryInfoElement element = payload.getCountryInfo();
		if (element != null) {
			entity.setCalendarTypeCode(element.getCalenderTypeCode());
			entity.setCountryCodeDescription(element
					.getCountryCodeDescription());
			entity.setCountryCode(element.getCountryCode());
			entity.setVersion(Integer.valueOf(element.getCountryCodeVersion()));
			entity.setCreatedOn(Calendar.getInstance().getTime());
			entity.setEffectiveEndDate(element.getCountryCodeEndDate()
					.getTime());
			entity.setEffectiveStartDate(element.getCountryCodeEffectiveDate()
					.getTime());
			entity.setHemisphereCode(element.getHemisphereCode());
			entity.setHemisphereDescription(element
					.getHemisphereCodeDescription());
			entity.setInternalCountryRegionCode(element
					.getInternalCountryRegionCode());
			entity.setInternalCountryRegionDescription(element
					.getInternalCountryRegionDescription());
			entity.setIsoAlpha2CountryCode(element.getIsoAlpha2CountryCode());
			entity.setIsoAlpha3CountryCode(element.getIsoAlpha3CountryCode());
			entity.setIsoIndicator(element.getIsoCodeIndicator());
			entity.setModifiedOn(Calendar.getInstance().getTime());
			entity.setNpcIndicator(element.getNpcIndicator());
			entity.setReferenceTableId(element.getReferenceTableId());
			entity.setSourceId(element.getSourceIdentifier());
		}
	}

	// private CountryKey getCountryCodeKey(Country payload) {
	// String countryCode = payload.getCountryInfo().getCountryCode();
	// String version = payload.getCountryInfo().getCountryCodeVersion();
	// CountryKey key = new CountryKey();
	// key.setCountryCode(countryCode);
	// key.setVersion(Integer.valueOf(version));
	// return key;
	// }
}
