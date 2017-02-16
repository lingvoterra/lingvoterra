package com.lingvoterra.logging;

import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

public class LogFormatter {

	private String rootXMLTag = "LT";
	private LogFormat outputFormat = LogFormat.XML;
	private FastDateFormat dateFormatter = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;
	private String delimiter = "|";

	public String getRootXMLTag() {
		return rootXMLTag;
	}

	public void setRootXMLTag(String rootXMLTag) {
		this.rootXMLTag = rootXMLTag;
	}

	public LogFormat getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(LogFormat outputFormat) {
		this.outputFormat = outputFormat;
	}

	public FastDateFormat getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(FastDateFormat dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String format(LogRecord logRecord) {
		String output = null;

		logRecord.putValue("timestamp", dateFormatter.format(logRecord.getTimeStamp()));

		switch (outputFormat) {
		case JSON:
			output = toJson(logRecord);
			break;
		case XML:
			output = toXML(logRecord);
			break;
		default:
			output = toDelimitedText(logRecord);
			break;
		}
		return output;
	}

	private String toJson(LogRecord logRecord) {
		Gson gson = new Gson();
		return gson.toJson(logRecord.getValues());
	}

	private String toXML(LogRecord logRecord) {
		JSONObject obj = new JSONObject(logRecord.getValues());
		return XML.toString(obj, rootXMLTag);
	}

	private String toDelimitedText(LogRecord logRecord) {

		StringBuilder builder = new StringBuilder();

		for (Map.Entry<String, Object> entry : logRecord.getValues().entrySet()) {
			builder.append(entry.getKey()).append(delimiter);
			builder.append(entry.getValue().toString()).append(delimiter);
		}
		return builder.toString();
	}
}
