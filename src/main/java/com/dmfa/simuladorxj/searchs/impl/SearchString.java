package com.dmfa.simuladorxj.searchs.impl;

import com.dmfa.simuladorxj.searchs.SearchMethod;
import com.dmfa.simuladorxj.utils.FileUtils;

public class SearchString implements SearchMethod {

	@Override
	public boolean find(String criteria, String evalValue, String pathContent) {
		String hasContent = String.valueOf(FileUtils.readFile(pathContent).contains(criteria));
		return hasContent.equalsIgnoreCase(evalValue);
	}

}
