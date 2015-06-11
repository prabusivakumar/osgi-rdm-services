package com.scb.edmi.xml.bind;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import com.scb.edmi.header.xml.binding.DocTypeRefNsSCBMLHeaderType;

public class EdmiMetadataMarshaller {

	private static final String METADATA_ROOT_ELEMENT = "HEADER";

	public static DocTypeRefNsSCBMLHeaderType unmarshalMetadata(String payload) {
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		StreamSource xml = new StreamSource(new StringReader(payload));
		XMLStreamReader streamReader;
		DocTypeRefNsSCBMLHeaderType response = null;
		try {
			streamReader = inputFactory.createXMLStreamReader(xml);
			while (streamReader.hasNext()) {
				if (streamReader.isStartElement()
						&& streamReader.getLocalName().equalsIgnoreCase(METADATA_ROOT_ELEMENT)) {
					break;
				}
				streamReader.next();
			}
			JAXBContext jc = JAXBContext.newInstance(DocTypeRefNsSCBMLHeaderType.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<DocTypeRefNsSCBMLHeaderType> jb = unmarshaller.unmarshal(streamReader,
					DocTypeRefNsSCBMLHeaderType.class);
			response = jb.getValue();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return response;
	}
}
