package com.abuabdul.notedovn.exception;

/**
 * An Application level exception, captures exception message and confine it as
 * RuntimeException so application can handle the exception message delicately
 * using exception resolvers
 * 
 * @author abuabdul
 *
 */
public class NoteDovnException extends RuntimeException {

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 434324L;

	public NoteDovnException() {

	}

	public NoteDovnException(String message) {
		super(message);
	}

	public NoteDovnException(Throwable cause) {
		super(cause);
	}

	public NoteDovnException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteDovnException(String message, Error error) {
		super(message, error);
	}
}
