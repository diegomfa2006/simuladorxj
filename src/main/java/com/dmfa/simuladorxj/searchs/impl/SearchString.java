package com.dmfa.simuladorxj.searchs.impl;

import com.dmfa.simuladorxj.searchs.SearchMethod;

public class SearchString implements SearchMethod {

	@Override
	public boolean find(String criteria, String evalValue, String content) {
		String hasContent = String.valueOf(content.contains(criteria));
		return hasContent.equalsIgnoreCase(evalValue);
	}

}
