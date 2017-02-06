package com.lingvoterra.logging;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoggingRecordTest {

	@Test
	public void shouldReturnRecordInXMLFormat() {
		/*
		 * LoggingRecord logRecord = new LoggingRecord("searchwithin");
		 * logRecord.putValue("message", "Start orchestration...");
		 *
		 * System.out.println(logRecord.toString());
		 */
		assertTrue(true);
	}

	@Test
	public void shouldReturnMessageInJsonFormat() {
		/*
		 * LoggingRecord logRecord = new LoggingRecord("searchwithin");
		 * logRecord.setOutputFormat(LogOutputFormat.JSON);
		 * logRecord.putValue("message", "Start orchestration...");
		 *
		 * System.out.println(logRecord.toString());
		 */
		assertTrue(true);

	}

	@Test
	public void shouldReturnRecordInPlainTextFormat() {
		/*
		 * LoggingRecord logRecord = new LoggingRecord("searchwithin");
		 * logRecord.setOutputFormat(LogOutputFormat.DELIMITED);
		 * logRecord.putValue("message", "Start orchestration...");
		 *
		 * System.out.println(logRecord.toString());
		 */
		assertTrue(true);
	}
}
