package com.dmfa.simuladorxj.utils;

import javax.servlet.http.HttpServletRequest;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.Config;
import com.dmfa.simuladorxj.beans.SearchCriteriaType;
import com.dmfa.simuladorxj.searchs.SearchMethod;
import com.dmfa.simuladorxj.searchs.impl.SearchRegex;
import com.dmfa.simuladorxj.searchs.impl.SearchString;
import com.dmfa.simuladorxj.searchs.impl.SearchXpath;

public class FindUtils {
	
	public static ApplicationType findApplication(Config config, HttpServletRequest rq) {
		for (ApplicationType applicationType : config.getApplications()) {
			if(search(applicationType.getSearchCriteria(), rq)) {
				return applicationType;
			}
		}
		return null;
	}

	
	public static boolean search(SearchCriteriaType search, HttpServletRequest rq) {
		String content = null;
		
		switch (search.getSourceContent()) {
		case PATH:
			content = rq.getRequestURI();
			break;

		default:
			content = rq.getQueryString(); 
			break;
		}
		
		SearchMethod searchMethod = null;
		switch (search.getSearchType()) {
		case REGEX:
			searchMethod = new SearchRegex();
			break;
			
		case XPATH:
			searchMethod = new SearchXpath();
			break;

		default:
			searchMethod = new SearchString();
			break;
		}
		
		return searchMethod.find(search.getCriteria(), search.getEvalValue(), content);
		
	}
}
