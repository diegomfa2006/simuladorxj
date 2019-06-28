package com.dmfa.simuladorxj.searchs.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmfa.simuladorxj.searchs.SearchMethod;
import com.dmfa.simuladorxj.utils.FileUtils;

public class SearchRegex implements SearchMethod {

	@Override
	public boolean find(String criteria, String evalValue, String pathContent) {

		Pattern pattern = Pattern.compile(criteria);
		Matcher matcher = pattern.matcher(FileUtils.readFile(pathContent));
		if (matcher.find() && matcher.group(1).equals(evalValue)) {
			return true;
		}

		return false;
	}

}
