package com.scb.rdm.camel.processor.currency;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.repository.CurrencyRepository;
import com.scb.rdm.xml.currency.binding.Currency;
import com.scb.rdm.xml.currency.binding.CurrencyInfoElement;
import com.scb.rdm.xml.currency.binding.PublishCurrencyRequest;

public class PublishCurrencyCodeRequestProcessor implements Processor {

	private CurrencyRepository currencyRepository;

	private static final Logger LOG = LoggerFactory
			.getLogger(PublishCurrencyCodeRequestProcessor.class);

	public CurrencyRepository getCurrencyRepository() {
		return currencyRepository;
	}

	public void setCurrencyRepository(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		List<CurrencyCode> entities = new ArrayList<CurrencyCode>();
		PublishCurrencyRequest publishCountryRequest = exchange.getIn()
				.getBody(PublishCurrencyRequest.class);
		for (Currency currency : publishCountryRequest
				.getPublishCurrencyReqPayload().getPublishCurrencyReq()) {
			CurrencyCode entity = this.currencyRepository
					.findByCurrencyCode(currency.getCurrencyInfo()
							.getCurrencyCode());
			if (entity == null) {
				LOG.info("Entity is null. creating dummy object of Currency Code");
				entity = new CurrencyCode();
			}
			LOG.info("Currency Code entity data: " + entity.getCurrencyCode());
			LOG.info("Currency Code entity data: " + entity.getVersion());
			merge(entity, currency);
			entities.add(entity);
		}
		this.currencyRepository.save(entities);
		exchange.getOut().setBody(entities);
	}

	private void merge(CurrencyCode entity, Currency payload) {
		CurrencyInfoElement element = payload.getCurrencyInfo();
		if (element != null) {
			entity.setCurrencyCodeDescription(element
					.getCurrencyCodeDescription());
			entity.setCurrencyCode(element.getCurrencyCode());
			entity.setVersion(Integer.valueOf(element.getCurrencyCodeVersion()));
			entity.setCreatedTimeStamp(Calendar.getInstance().getTime());
			entity.setEffectiveEndDate(element.getCurrencyCodeEndDate()
					.getTime());
			entity.setEffectiveStartDate(element.getCurrencyCodeEffectiveDate()
					.getTime());
			entity.setIsoAlpha3CurrencyCode(element.getIsoAlpha3CurrencyCode());
			entity.setIsoCodeIndicator(element.getIsoCodeIndicator());
			entity.setModifiedTimeStamp(Calendar.getInstance().getTime());
			entity.setReferenceTableId(element.getReferenceTableId());
			entity.setSourceId(element.getSourceIdentifier());
			entity.setIsoNumericCode(element.getSourceIdentifier());
			entity.setPsglCurrencyIndicator(element
					.getPSGLStandardCurrencyIndicator());
			entity.setAchillesExchangeRateIndicator(element
					.getDataCustodianIndicator());
			entity.setCountryCode(element.getCountryCode());
			entity.setCountryCodeDescription(element.getCountryDescription());
			entity.setExchangeRateDenomination(element
					.getExchangeRateDenomination());
			entity.setCurrencyRoundingDecimalPlace(element
					.getCurrencyRoundingDecimalPlace());
		}
	}

	// private CurrencyKey getCurrencyCodeKey(Currency payload) {
	// String currencyCode = payload.getCurrencyInfo().getCurrencyCode();
	// String version = payload.getCurrencyInfo().getCurrencyCodeVersion();
	// CurrencyKey key = new CurrencyKey();
	// key.setCurrencyCode(currencyCode);
	// key.setVersion(Integer.valueOf(version));
	// return key;
	// }

}
