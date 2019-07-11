package com.dmfa.simuladorxj.searchs.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.dmfa.simuladorxj.searchs.SearchMethod;

public class SearchXpath implements SearchMethod {

	@Override
	public boolean find(String criteria, String evalValue, String content) {
		try {
			InputStream fileIS = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(fileIS);
			XPath xPath = XPathFactory.newInstance().newXPath();
			Node nodeList = (Node) xPath.compile(criteria).evaluate(xmlDocument, XPathConstants.NODE);
			return evalValue.equals(nodeList.getTextContent());
			
		} catch (ParserConfigurationException | XPathExpressionException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
