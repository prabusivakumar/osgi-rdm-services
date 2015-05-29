package com.scb.rdm.type;

public enum StandardCodeType {

	SEGMENT_CODE("5", null), 
	SUBSEGMENT_CODE("6", SEGMENT_CODE), 
	ISIC_CODE("17", null), 
	LEGAL_CONSTITUTION_CODE("56", null), 
	BASEL_SEGMENT_CODE("57", null), 
	BASEL_SUBSEGMENT_CODE("58", BASEL_SEGMENT_CODE);

	private String codeType;
	private StandardCodeType parentStandardCodeType;

	private StandardCodeType(String codeType, StandardCodeType parentStandardCodeType) {
		this.codeType = codeType;
		this.parentStandardCodeType = parentStandardCodeType;
	}

	public static StandardCodeType build(String codeType) {
		for(StandardCodeType standardCodeType : StandardCodeType.values()) {
			if(codeType.equals(standardCodeType.getCodeType())) {
				return standardCodeType;
			}
		}
		throw new IllegalArgumentException("Invalid Standard Code Type. ");
	}

	public String getCodeType() {
		return codeType;
	}

	public StandardCodeType getParentStandardCodeType() {
		return parentStandardCodeType;
	}
}
