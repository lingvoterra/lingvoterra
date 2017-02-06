package com.lingvoterra.logging;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;

public class CommonLogger {

	@Value("${logging.logs.output.format}")
	private LoggingOutputFormat loggingOutputFormat = LoggingOutputFormat.XML;

	private Logger LOGGER = Logger.getLogger(CommonLogger.class);
	private List<LoggingMessage> messages;

	public CommonLogger() {
		messages = new ArrayList<LoggingMessage>();
	}

	public void addMessage(String message) {
		// messages.add(new );
	}

}
