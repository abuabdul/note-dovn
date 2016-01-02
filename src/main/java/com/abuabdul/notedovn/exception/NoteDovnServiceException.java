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
