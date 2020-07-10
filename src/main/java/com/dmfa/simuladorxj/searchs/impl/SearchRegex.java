package com.dmfa.simuladorxj.searchs.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dmfa.simuladorxj.searchs.SearchMethod;

public class SearchRegex implements SearchMethod {

	@Override
	public boolean find(String criteria, String evalValue, String content) {

//		Pattern pattern = Pattern.compile(criteria);
//		Matcher matcher = pattern.matcher(FileUtils.readFile(content));
//		if (matcher.find() && matcher.group(1).equals(evalValue)) {
//			return true;
//		}
//
//		return false;
		
		Pattern pattern = Pattern.compile(criteria);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find() ) {
			return true;
		}
		return false;
	}

}
