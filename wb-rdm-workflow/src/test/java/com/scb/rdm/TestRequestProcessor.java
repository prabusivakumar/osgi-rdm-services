package com.scb.rdm;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.rdm.camel.processor.country.PublishCountryCodeRequestProcessor;
import com.scb.rdm.camel.processor.currency.PublishCurrencyCodeRequestProcessor;
import com.scb.rdm.camel.processor.standardCode.PublishStandardCodeRequestProcessor;
import com.scb.rdm.camel.processor.standardCode.StandardCodeTransformer;
import com.scb.rdm.entity.CountryCode;
import com.scb.rdm.entity.CurrencyCode;
import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.repository.CurrencyRepository;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.rdm.repository.StandardCodeRepository;
import com.scb.rdm.xml.country.binding.Country;
import com.scb.rdm.xml.country.binding.CountryInfoElement;
import com.scb.rdm.xml.country.binding.PublishCountryReqPayload;
import com.scb.rdm.xml.country.binding.PublishCountryRequest;
import com.scb.rdm.xml.currency.binding.Currency;
import com.scb.rdm.xml.currency.binding.CurrencyInfoElement;
import com.scb.rdm.xml.currency.binding.PublishCurrencyReqPayload;
import com.scb.rdm.xml.currency.binding.PublishCurrencyRequest;
import com.scb.rdm.xml.standard.binding.PublishStandardCodesReqPayload;
import com.scb.rdm.xml.standard.binding.PublishStandardCodesRequest;
import com.scb.rdm.xml.standard.binding.StandardCode;
import com.scb.rdm.xml.standard.binding.StandardCodeInfoElement;

public class TestRequestProcessor {

	@InjectMocks
	private PublishCountryCodeRequestProcessor countryCodeReqProcessor;

	@InjectMocks
	private PublishCurrencyCodeRequestProcessor currencyCodeReqProcessor;

	@InjectMocks
	private PublishStandardCodeRequestProcessor standardCodeRequestProcessor;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test case is used to test the PublishCountryCodeRequestProcessor
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCaseCountryProcessor() throws Throwable {
		final CountryRepository countryRepository = Mockito
				.mock(CountryRepository.class);
		final Exchange ex = Mockito.mock(Exchange.class);
		PublishCountryRequest countryRequest = new PublishCountryRequest();
		PublishCountryReqPayload reqPayload = new PublishCountryReqPayload();
		Country ctry = new Country();
		ctry.setCountryInfo(new CountryInfoElement());
		ctry.getCountryInfo().setCountryCodeVersion("1");
		ctry.getCountryInfo().setCountryCodeEndDate(Calendar.getInstance());
		ctry.getCountryInfo().setCountryCodeEffectiveDate(
				Calendar.getInstance());
		reqPayload.getPublishCountryReq().add(ctry);
		countryRequest.setPublishCountryReqPayload(reqPayload);
		when(
				countryRepository.findByCountryCode(ctry.getCountryInfo()
						.getCountryCode())).thenReturn(new CountryCode());
		Message mockMessage = Mockito.mock(Message.class);
		when(ex.getIn()).thenReturn(mockMessage);
		when(mockMessage.getBody(PublishCountryRequest.class)).thenReturn(
				countryRequest);
		List entities = new ArrayList<Iterable>();
		countryCodeReqProcessor.setCountryRepository(countryRepository);
		when(countryRepository.save(entities)).thenReturn(entities);
		when(ex.getOut()).thenReturn(mockMessage);
		countryCodeReqProcessor.process(ex);
	}

	/**
	 * This test case is used to test the PublishCurrencyCodeRequestProcessor
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCaseCurrencyProcessor() throws Throwable {
		final CurrencyRepository currencyRepository = Mockito
				.mock(CurrencyRepository.class);
		final Exchange ex = Mockito.mock(Exchange.class);
		PublishCurrencyRequest currencyRequest = new PublishCurrencyRequest();
		PublishCurrencyReqPayload reqPayload = new PublishCurrencyReqPayload();
		Currency curr = new Currency();
		curr.setCurrencyInfo(new CurrencyInfoElement());
		curr.getCurrencyInfo().setCurrencyCodeVersion("1");
		curr.getCurrencyInfo().setCurrencyCodeEndDate(Calendar.getInstance());
		curr.getCurrencyInfo().setCurrencyCodeEffectiveDate(
				Calendar.getInstance());
		reqPayload.getPublishCurrencyReq().add(curr);
		currencyRequest.setPublishCurrencyReqPayload(reqPayload);
		Message mockMessage = Mockito.mock(Message.class);
		when(
				currencyRepository.findByCurrencyCode(curr.getCurrencyInfo()
						.getCurrencyCode())).thenReturn(new CurrencyCode());
		when(ex.getIn()).thenReturn(mockMessage);
		when(mockMessage.getBody(PublishCurrencyRequest.class)).thenReturn(
				currencyRequest);
		List entities = new ArrayList<Iterable>();
		currencyCodeReqProcessor.setCurrencyRepository(currencyRepository);
		when(currencyRepository.save(entities)).thenReturn(entities);
		when(ex.getOut()).thenReturn(mockMessage);
		currencyCodeReqProcessor.process(ex);
	}

	/**
	 * This test case is used to test the PublishStandardCodeRequestProcessor
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCaseStandardCodeProcessor() throws Throwable {
		final StandardCodeRepository standardCodeRepository = Mockito
				.mock(StandardCodeRepository.class);
		final StandardCodePicklistRepository standardCodePicklistRepository = Mockito
				.mock(StandardCodePicklistRepository.class);
		final StandardCodeTransformer standardCodeTransformer = Mockito
				.mock(StandardCodeTransformer.class);
		final Exchange ex = Mockito.mock(Exchange.class);
		PublishStandardCodesRequest standardCodesRequest = new PublishStandardCodesRequest();
		PublishStandardCodesReqPayload reqPayload = new PublishStandardCodesReqPayload();
		StandardCode standardCode = new StandardCode();
		standardCode.setStandardCodeInfo(new StandardCodeInfoElement());
		reqPayload.getPublishStandardCodesReq().add(standardCode);
		standardCodesRequest.setPublishStandardCodesReqPayload(reqPayload);
		Message mockMessage = Mockito.mock(Message.class);
		when(ex.getIn()).thenReturn(mockMessage);
		when(mockMessage.getBody(PublishStandardCodesRequest.class))
				.thenReturn(standardCodesRequest);
		List entities = new ArrayList<Iterable>();
		standardCodeRequestProcessor
				.setStandardCodePicklistRepository(standardCodePicklistRepository);
		standardCodeRequestProcessor.setStandardCodeTransformer(standardCodeTransformer);
		StandardCodePicklist mockStandardCodePicklist = new StandardCodePicklist();
		mockStandardCodePicklist.setStandardCode(new com.scb.rdm.entity.StandardCode());
		when(
				standardCodeTransformer.transform(standardCode
						.getStandardCodeInfo())).thenReturn(
				mockStandardCodePicklist);
		when(standardCodePicklistRepository.save(entities))
				.thenReturn(entities);
		when(ex.getOut()).thenReturn(mockMessage);
		standardCodeRequestProcessor.process(ex);
	}

}
