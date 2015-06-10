package com.scb.rdm;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.rdm.camel.processor.standardCode.StandardCodeTransformer;
import com.scb.rdm.entity.StandardCodePicklist;
import com.scb.rdm.repository.StandardCodePicklistRepository;
import com.scb.rdm.repository.StandardCodePicklistValueRepository;
import com.scb.rdm.repository.StandardCodeRepository;
import com.scb.rdm.xml.standard.binding.PublishStandardCodesReqPayload;
import com.scb.rdm.xml.standard.binding.PublishStandardCodesRequest;
import com.scb.rdm.xml.standard.binding.StandardCode;
import com.scb.rdm.xml.standard.binding.StandardCodeInfoElement;

public class TestTransformer {

	@InjectMocks
	private StandardCodeTransformer standardCodeTransformer;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test case is used to test the StandardCodeTransformer
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCaseStandardCodeTransformer() throws Throwable {
		final StandardCodeRepository standardCodeRepository = Mockito
				.mock(StandardCodeRepository.class);
		final StandardCodePicklistRepository standardCodePicklistRepository = Mockito
				.mock(StandardCodePicklistRepository.class);
		final StandardCodePicklistValueRepository standardCodePicklistValueRepository = Mockito
				.mock(StandardCodePicklistValueRepository.class);
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
		standardCodeTransformer
				.setStandardCodePicklistRepository(standardCodePicklistRepository);
		standardCodeTransformer
				.setStandardCodePicklistValueRepository(standardCodePicklistValueRepository);
		StandardCodePicklist mockStandardCodePicklist = new StandardCodePicklist();
		mockStandardCodePicklist
				.setStandardCode(new com.scb.rdm.entity.StandardCode());
		when(
				standardCodePicklistRepository.findByCodeIdAndCodeValue(
						standardCode.getStandardCodeInfo().getStdCodeType(),
						standardCode.getStandardCodeInfo().getStdCode()))
				.thenReturn(entities);
		when(
				standardCodePicklistValueRepository.findByCodeIdAndCodeValue(
						standardCode.getStandardCodeInfo().getStdCodeType(),
						standardCode.getStandardCodeInfo().getStdCode()))
				.thenReturn(entities);
		when(standardCodePicklistRepository.save(entities))
				.thenReturn(entities);
		when(ex.getOut()).thenReturn(mockMessage);
		standardCodeTransformer.transform(standardCode.getStandardCodeInfo());
	}

}
