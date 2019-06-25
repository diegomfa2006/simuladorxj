package com.dmfa.simuladorxj.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.dmfa.simuladorxj.beans.Config;

public class XmlUtils {

	public static Config parseToObject(File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Config) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO cambiar a log4j
			e.printStackTrace();
			return null;
		}
	}

}
