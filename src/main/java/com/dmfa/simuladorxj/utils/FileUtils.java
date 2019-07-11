package com.dmfa.simuladorxj.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

	public static String readFile(String path) {
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}
	
	public static boolean saveFile(String path, String content) {
		try (PrintWriter out = new PrintWriter(path)) {
		    out.println(content);
		    return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static String convertToString (InputStream inputStream, String encoding) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
		    result.write(buffer, 0, length);
		}
		inputStream = new ByteArrayInputStream(result.toByteArray());
		// StandardCharsets.UTF_8.name() > JDK 7
		return result.toString(encoding);

	}
	
	public static String convertToString (BufferedReader bufferedReader) throws IOException {
		String response = new String();
		for (String line; (line = bufferedReader.readLine()) != null; response += line);
		
		return response;

	}
}
