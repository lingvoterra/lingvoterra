package com.lingvoterra.logging;

public class LogContext {

	private static AppLogger logger;
	private static LogFormatter logFormatter;

	public static AppLogger getLogger() {
		if (logger == null) {
			return new AppLogger();
		}
		return logger;
	}

	public static LogFormatter getLogFormatter() {
		if (logFormatter == null) {
			return new LogFormatter();
		}
		return logFormatter;
	}
}
