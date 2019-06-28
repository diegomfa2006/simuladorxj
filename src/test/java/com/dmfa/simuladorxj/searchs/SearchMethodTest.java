package com.dmfa.simuladorxj.searchs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dmfa.simuladorxj.searchs.impl.SearchXpath;

class SearchMethodTest {

	@Test
	void testSearchXpath() {
		SearchMethod search = new SearchXpath();
		
		assertTrue(search.find("/config/application/name", "aplicacionPrueba", "./src/test/resources/xml/prueba.xml"));
	}

}
