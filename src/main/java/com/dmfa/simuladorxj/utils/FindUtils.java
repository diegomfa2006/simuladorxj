package com.dmfa.simuladorxj.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.dmfa.simuladorxj.beans.ApplicationType;
import com.dmfa.simuladorxj.beans.Config;
import com.dmfa.simuladorxj.beans.MessageType;
import com.dmfa.simuladorxj.beans.SearchCriteriaType;
import com.dmfa.simuladorxj.searchs.SearchMethod;
import com.dmfa.simuladorxj.searchs.impl.SearchRegex;
import com.dmfa.simuladorxj.searchs.impl.SearchString;
import com.dmfa.simuladorxj.searchs.impl.SearchXpath;

public class FindUtils {
	
	public static ApplicationType findApplication(Config config, HttpServletRequest rq) throws IOException {
		for (ApplicationType applicationType : config.getApplications()) {
			if(search(applicationType.getSearchCriteria(), rq)) {
				return applicationType;
			}
		}
		return null;
	}
	
	public static MessageType findMessage(ApplicationType application, HttpServletRequest rq) throws IOException {
		for (MessageType messageType : application.getMessages()) {
			if(search(messageType.getSearchCriteria(), rq)) {
				return messageType;
			}
		}
		return null;
	}

	
	public static String getContent(SearchCriteriaType search, HttpServletRequest rq) throws IOException {
		switch (search.getSourceContent()) {
		case PATH:
			return rq.getRequestURI();

		default:
			return FileUtils.convertToString(rq.getInputStream(), "UTF-8"); 
		}
	}
	
	public static SearchMethod getSearchMethodByType(SearchCriteriaType search) {
		switch (search.getSearchType()) {
		case REGEX:
			return new SearchRegex();
			
		case XPATH:
			return new SearchXpath();

		default:
			return new SearchString();
		}
	}
	
	private static boolean search(SearchCriteriaType search, HttpServletRequest rq) throws IOException {
		SearchMethod searchMethod = getSearchMethodByType(search);
		return searchMethod.find(search.getCriteria(), search.getEvalValue(), getContent(search, rq));
	}
}
