package com.lingvoterra.logging;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class LogRecord {

	private String message;
	private Date timeStamp;
	private Map<String, Object> values = new LinkedHashMap<String, Object>();

	public LogRecord() {
	}

	public LogRecord(String message) {
		this.message = message;

		// Set time stamp of a record
		timeStamp = Calendar.getInstance().getTime();
		values.put("timestamp", timeStamp);
		values.put("message", message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		values.put("message", this.message);
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
		values.put("timestamp", this.timeStamp);
	}

	public void putValue(String key, Object value) {
		values.put(key, value);
	}

	public Object getValue(String key) {
		return values.get(key);
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
}
