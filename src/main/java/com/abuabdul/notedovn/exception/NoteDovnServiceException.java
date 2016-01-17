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
package com.abuabdul.notedovn.exception;

/**
 * Handles Service layer exceptions
 * 
 * @author abuabdul
 *
 */
public class NoteDovnServiceException extends Exception {

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 3456L;

	public NoteDovnServiceException() {

	}

	public NoteDovnServiceException(String message) {
		super(message);
	}

	public NoteDovnServiceException(Throwable cause) {
		super(cause);
	}

	public NoteDovnServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteDovnServiceException(String message, Error error) {
		super(message, error);
	}
}
