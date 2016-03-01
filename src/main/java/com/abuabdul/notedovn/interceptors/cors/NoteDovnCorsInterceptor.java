/*
 * Copyright 2013-2016 abuabdul.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.abuabdul.notedovn.interceptors.cors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author abuabdul
 *
 */
public class NoteDovnCorsInterceptor extends HandlerInterceptorAdapter {

	@Value("${notedovn.app.origins}")
	private String origins;

	public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
	public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
	public static final String METHODS_NAME = "Access-Control-Allow-Methods";
	public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
	public static final String MAX_AGE_NAME = "Access-Control-Max-Age";

	public static final String REQUEST_ORIGIN_NAME = "Origin";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String origin = request.getHeader(REQUEST_ORIGIN_NAME);
		if (origins.equalsIgnoreCase(origin)) {
			response.setHeader(CREDENTIALS_NAME, "true");
			response.setHeader(ORIGIN_NAME, origin);
			response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
			response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
			response.setHeader(MAX_AGE_NAME, "3600");
		}
		return true;
	}

}
