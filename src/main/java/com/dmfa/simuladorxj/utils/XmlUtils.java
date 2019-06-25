package com.dmfa.simuladorxj.utils;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
	
	public static String parseToXml(Config config) {
		try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
             
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(config, sw);
             
            return sw.toString();
 
        } catch (JAXBException e) {
        	// TODO cambiar a log4j
            e.printStackTrace();
            return null;
        }
		
	}

}
