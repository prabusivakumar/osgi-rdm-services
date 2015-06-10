package com.scb.rdm;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jms.TextMessage;

import org.apache.camel.Exchange;
import org.apache.camel.component.jms.JmsMessage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.rdm.camel.processor.InterfaceMessageProcessor;
import com.scb.rdm.repository.InterfaceMessageRepository;
import com.scb.rdm.xml.country.binding.Country;
import com.scb.rdm.xml.country.binding.CountryInfoElement;
import com.scb.rdm.xml.country.binding.PublishCountryReqPayload;
import com.scb.rdm.xml.country.binding.PublishCountryRequest;

public class TestInterfaceMessageProcessor {

	@InjectMocks
	private InterfaceMessageProcessor interfaceMessageProcessor;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test case is used to test the InterfaceMessageProcessor
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCaseInterfaceMessageProcessor() throws Throwable {
		final InterfaceMessageRepository interfaceMessageRepository = Mockito
				.mock(InterfaceMessageRepository.class);
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
		JmsMessage mockMessage = Mockito.mock(JmsMessage.class);
		when(ex.getIn(JmsMessage.class)).thenReturn(mockMessage);
		TextMessage textMsg = Mockito.mock(TextMessage.class);
		when(mockMessage.getJmsMessage()).thenReturn(textMsg);
		String str = "<?xml version=\"1.0\"?><ns:SCBML xmlns:ns=\"http://www.sc.com/SCBML-1\" xmlns:ctry=\"http://www.sc.com/referenceData/v1/country\"><ns:header><ns:messageDetails><ns:messageVersion>1.0</ns:messageVersion><ns:messageType><ns:typeName>CountryCodes</ns:typeName><ns:subType subTypeScheme=\"http://www.sc.com/coding-scheme/subtypescheme-1-0\"><ns:subTypeName>Incremental</ns:subTypeName></ns:subType></ns:messageType></ns:messageDetails><ns:originationDetails><ns:messageSender><ns:messageSender systemScheme=\"http://www.sc.com/coding-scheme/system-1-0\">RDM</ns:messageSender><ns:senderDomain><ns:domainName domainNameScheme=\"http://www.sc.com/coding-scheme/domainNamescheme-1-0\">Referential</ns:domainName><ns:subDomainName subdomainNameScheme=\"http://www.sc.com/coding-scheme/subdomainNamescheme-1-0\"><ns:subDomainType>RDM</ns:subDomainType></ns:subDomainName></ns:senderDomain><ns:currencyCode>All</ns:currencyCode></ns:messageSender><ns:messageTimestamp>2014-11-12T16:47:07</ns:messageTimestamp><ns:initiatedTimestamp>2014-11-12T16:47:07</ns:initiatedTimestamp><ns:trackingId>5501</ns:trackingId><ns:possibleDuplicate>FALSE</ns:possibleDuplicate></ns:originationDetails><ns:captureSystem>RDM</ns:captureSystem><ns:process><ns:eventType>UPDATE</ns:eventType></ns:process></ns:header></ns:SCBML>";
		when(textMsg.getText()).thenReturn(str);
		List entities = new ArrayList<Iterable>();
		interfaceMessageProcessor
				.setInterfaceMessageRepository(interfaceMessageRepository);
		when(interfaceMessageRepository.save(entities)).thenReturn(entities);
		when(ex.getOut()).thenReturn(mockMessage);
		interfaceMessageProcessor.process(ex);
	}

}
