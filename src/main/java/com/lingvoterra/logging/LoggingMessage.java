package com.lingvoterra.logging;

import java.util.Calendar;
import java.util.Date;

public class LoggingMessage {

	private long timeStamp;
	private String message;
	private boolean isErrorMessage;

	public LoggingMessage(long timeStamp, String message, boolean isErrorMessage) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.isErrorMessage = isErrorMessage;
	}

	public Date getTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeStamp);

		return calendar.getTime();
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isErrorMessage() {
		return isErrorMessage;
	}

	public void setErrorMessage(boolean isErrorMessage) {
		this.isErrorMessage = isErrorMessage;
	}
}
