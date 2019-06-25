package com.dmfa.simuladorxj.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.dmfa.simuladorxj.beans.Config;

class XmlUtilsTest {

	@Test
	void parseToObject() {
		Config config = XmlUtils.parseToObject(new File("src/test/resources/xml/prueba.xml"));
		assertEquals(1, config.getAplications().size());
	}

}
