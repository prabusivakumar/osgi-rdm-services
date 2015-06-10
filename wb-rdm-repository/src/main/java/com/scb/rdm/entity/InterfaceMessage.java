package com.scb.rdm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INT_MESSAGE")
public class InterfaceMessage implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "INT_MSG_ID", precision = 38, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_message_sequence")
	@SequenceGenerator(name = "event_message_sequence", sequenceName = "EVENT_MESSAGE_SEQ")
	private BigDecimal id;

	@Column(name = "MESSAGE_TYPE", length = 120)
	private String messageType;

	@Column(name = "MESSAGE_SUB_TYPE", length = 120)
	private String messageSubType;

	@Column(name = "MESSAGE_SENDER", length = 120)
	private String messageSender;

	@Column(name = "MESSAGE_TIMESTAMP")
	private Date messageTimestamp;

	@Column(name = "INITIATED_TIMESTAMP")
	private Date initiatedTimestamp;

	@Column(name = "TRACKING_ID", length = 120)
	private String trackingId;

	@Column(name = "CORRELATION_ID", length = 120)
	private String correlationId;

	@Column(name = "CONVERSATION_ID", length = 120)
	private String conversationId;

	@Column(name = "CAPTURE_SYSTEM", length = 120)
	private String captureSystem;

	@Column(name = "PROCESS_NAME", length = 120)
	private String processName;

	@Column(name = "EVENT_TYPE", length = 120)
	private String eventType;

	@Column(name = "ACTION", length = 120)
	private String action;

	@Column(name = "PAYLOAD")
	@Lob
	private String payload;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "CREATED_BY", length = 120)
	private String createdBy;

	@Column(name = "UPDATED_BY", length = 120)
	private String updatedBy;

	@Column(name = "ERROR_DESC", length = 4000)
	private String errorDescription;

	@Column(name = "IS_POSSIBLE_DUPLICATE")
	private Boolean possibleDuplicate;

	@Column(name = "STATUS", length = 20)
	@Enumerated(EnumType.STRING)
	private InterfaceMessageStatus status;

	public static enum InterfaceMessageStatus {
		PENDING, PROCESSED, FAILED;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the messageSubType
	 */
	public String getMessageSubType() {
		return messageSubType;
	}

	/**
	 * @param messageSubType
	 *            the messageSubType to set
	 */
	public void setMessageSubType(String messageSubType) {
		this.messageSubType = messageSubType;
	}

	/**
	 * @return the messageSender
	 */
	public String getMessageSender() {
		return messageSender;
	}

	/**
	 * @param messageSender
	 *            the messageSender to set
	 */
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	/**
	 * @return the messageTimestamp
	 */
	public Date getMessageTimestamp() {
		return messageTimestamp;
	}

	/**
	 * @param messageTimestamp
	 *            the messageTimestamp to set
	 */
	public void setMessageTimestamp(Date messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	/**
	 * @return the initiatedTimestamp
	 */
	public Date getInitiatedTimestamp() {
		return initiatedTimestamp;
	}

	/**
	 * @param initiatedTimestamp
	 *            the initiatedTimestamp to set
	 */
	public void setInitiatedTimestamp(Date initiatedTimestamp) {
		this.initiatedTimestamp = initiatedTimestamp;
	}

	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId
	 *            the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId
	 *            the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the conversationId
	 */
	public String getConversationId() {
		return conversationId;
	}

	/**
	 * @param conversationId
	 *            the conversationId to set
	 */
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	/**
	 * @return the captureSystem
	 */
	public String getCaptureSystem() {
		return captureSystem;
	}

	/**
	 * @param captureSystem
	 *            the captureSystem to set
	 */
	public void setCaptureSystem(String captureSystem) {
		this.captureSystem = captureSystem;
	}

	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * @param processName
	 *            the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the status
	 */
	public InterfaceMessageStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(InterfaceMessageStatus status) {
		this.status = status;
	}

	/**
	 * @return the possibleDuplicate
	 */
	public Boolean getPossibleDuplicate() {
		return possibleDuplicate;
	}

	/**
	 * @param possibleDuplicate
	 *            the possibleDuplicate to set
	 */
	public void setPossibleDuplicate(Boolean possibleDuplicate) {
		this.possibleDuplicate = possibleDuplicate;
	}

}