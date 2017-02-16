package com.lingvoterra.logging;

import org.apache.log4j.Logger;

public class AppLogger {

	private Logger LOGGER = Logger.getLogger(AppLogger.class);

	private LogFormatter logRecordFormatter = LogContext.getLogFormatter();

	public void info(String message) {
		LogRecord logRecord = new LogRecord(message);
		String formattedLog = logRecordFormatter.format(logRecord);
		LOGGER.info(formattedLog);
	};

	public void info(LogRecord logRecord) {
		String formattedLog = logRecordFormatter.format(logRecord);
		LOGGER.info(formattedLog);
	};

	public void error(String message) {
		LogRecord logRecord = new LogRecord(message);
		String formattedLog = logRecordFormatter.format(logRecord);
		LOGGER.error(formattedLog);
	};

	public void error(LogRecord logRecord) {
		String formattedLog = logRecordFormatter.format(logRecord);
		LOGGER.error(formattedLog);
	};

}
