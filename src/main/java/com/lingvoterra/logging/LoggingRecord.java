package com.lingvoterra.logging;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Value;

public class LoggingRecord {

	private Date timeStamp;

	@Value("${logging.logs.output.format}")
	private LoggingOutputFormat loggingOutputFormat = LoggingOutputFormat.XML;

	@Value("${logging.logs.root.xml.tag}")
	private String rootXmlTag = "LT";

	private Map<String, Object> values = new LinkedHashMap<String, Object>();
	private FastDateFormat dateFormat = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;

	public LoggingRecord() {

		// Set time stamp of a record
		timeStamp = Calendar.getInstance().getTime();
		values.put("timestamp", dateFormat.format(timeStamp));
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
		values.put("timestamp", dateFormat.format(timeStamp));
	}

	public void putValue(String key, Object value) {
		values.put(key, value);
	}

	public Object getValue(String key) {
		return values.get(key);
	}

	public LoggingOutputFormat getLoggingOutputFormat() {
		return loggingOutputFormat;
	}

	public void setOutputFormat(LoggingOutputFormat format) {
		loggingOutputFormat = format;
	}

	@Override
	public String toString() {
		return null;
	}

	private String convertToString() {
		return null;
	}

	private String convertToXml() {
		return null;
	}

	private String convertToJson() {
		return null;
	}

	private String convertToText() {
		return null;
	}

}
