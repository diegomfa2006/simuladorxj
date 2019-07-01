package com.dmfa.simuladorxj.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dmfa.simuladorxj.beans.HeaderType;

public class HeaderUtils {

	public static HttpServletResponse setHeaders(HttpServletResponse response, List<HeaderType> headers) {
		if (headers!=null && !headers.isEmpty()) {
			for (HeaderType header : headers) {
				response.setHeader(header.getKey(), header.getValue());
			}
		}
		return response;
	}
}
