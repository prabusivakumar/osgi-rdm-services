package com.scb.rdm.camel.processor;

import java.util.Calendar;

import javax.jms.TextMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jms.JmsMessage;



import com.scb.edmi.header.xml.binding.DocTypeRefNsSCBMLHeaderType;
import com.scb.edmi.xml.bind.EdmiMetadataMarshaller;
//import com.scb.event.message.generator.MessageSequenceIncrementer;
//import com.scb.edmi.header.xml.binding.DocTypeRefNsSCBMLHeaderType;
import com.scb.rdm.entity.InterfaceMessage.InterfaceMessageStatus;
import com.scb.rdm.entity.InterfaceMessage;
import com.scb.rdm.repository.InterfaceMessageRepository;



public class InterfaceMessageProcessor implements Processor {
	
	private InterfaceMessageRepository interfaceMessageRepository;	

	@Override
	public void process(Exchange exchange) throws Exception {
		JmsMessage payload = exchange.getIn(JmsMessage.class);
		String payloadStr = ((TextMessage) payload.getJmsMessage()).getText();
		DocTypeRefNsSCBMLHeaderType metadata = EdmiMetadataMarshaller.unmarshalMetadata(payloadStr);
//		PublishCountryRequest publishCountryRequest = exchange.getIn().getBody(PublishCountryRequest.class);
		InterfaceMessage entity = new InterfaceMessage();		
//		DocTypeRefNsSCBMLHeaderType metadata = publishCountryRequest.getHeader();		
		if (metadata.getMessageDetails() != null && metadata.getMessageDetails().getMessageType() != null)
			entity.setMessageType(metadata.getMessageDetails().getMessageType().getTypeName());

		if (metadata.getMessageDetails() != null && metadata.getMessageDetails().getMessageType() != null
				&& metadata.getMessageDetails().getMessageType().getSubType() != null)
			entity.setMessageSubType(metadata.getMessageDetails().getMessageType().getSubType().getSubTypeName());
		entity.setCaptureSystem(metadata.getCaptureSystem());
		if (metadata.getOriginationDetails() != null) {
			entity.setConversationId(metadata.getOriginationDetails().getConversationID());
			entity.setCorrelationId(metadata.getOriginationDetails().getCorrelationID());
			entity.setTrackingId(metadata.getOriginationDetails().getTrackingId());
			entity.setInitiatedTimestamp(metadata.getOriginationDetails().getInitiatedTimestamp() != null ? metadata
					.getOriginationDetails().getInitiatedTimestamp().getTime() : null);
			entity.setMessageTimestamp(metadata.getOriginationDetails().getMessageTimestamp() != null ? metadata
					.getOriginationDetails().getMessageTimestamp().getTime() : null);
		}

		if (metadata.getProcess() != null) {
			entity.setProcessName(metadata.getProcess().getProcessName());
			entity.setEventType(metadata.getProcess().getEventType());
			entity.setAction(metadata.getProcess().getAction());

		}
		entity.setCreatedOn(Calendar.getInstance().getTime());
		entity.setUpdatedOn(Calendar.getInstance().getTime());		
		if (payload.getJmsMessage() instanceof TextMessage)
			entity.setPayload(payloadStr);
		entity.setStatus(InterfaceMessageStatus.PROCESSED);		
		interfaceMessageRepository.save(entity);
	}



	public InterfaceMessageRepository getInterfaceMessageRepository() {
		return interfaceMessageRepository;
	}



	public void setInterfaceMessageRepository(
			InterfaceMessageRepository interfaceMessageRepository) {
		this.interfaceMessageRepository = interfaceMessageRepository;
	}

}
