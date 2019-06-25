package com.dmfa.simuladorxj.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileUtilsTest {
	
	@TempDir
    Path tempDir;

	@Test
	void readFile() {
		String textFile = FileUtils.readFile("src/test/resources/xml/prueba.xml");
		assertTrue(textFile.contains("aplicacionPrueba"));
	}
	
	@Test
	void saveFile() {
		assertTrue(FileUtils.saveFile(tempDir.resolve("output.txt").toString(), "holaMundo"));
	}

}
