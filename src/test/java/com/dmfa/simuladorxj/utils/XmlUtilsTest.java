package com.dmfa.simuladorxj.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.Config;

class XmlUtilsTest {

	@Test
	void parseToObject() {
		Config config = XmlUtils.parseToObject(new File("src/test/resources/xml/prueba.xml"));
		assertEquals(1, config.getApplications().size());
	}

	@Test
	void parseToXml() {
		Config config = new Config();
		ApplicationType app = new ApplicationType();
		app.setName("aplicaciongenerado");
		config.getApplications().add(app);
		
		System.out.println(XmlUtils.parseToXml(config));
		assertTrue(XmlUtils.parseToXml(config).contains("aplicaciongenerado"));
	}
}
