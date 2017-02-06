package com.lingvoterra.words.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordListPageRequestTest {

	@Test
	public void shouldGenerateJsonRepresentation() throws JsonGenerationException, JsonMappingException, IOException {
		String expectedResult = "{\"startIndex\":8,\"numberOfElements\":25}";

		WordListPageRequest wordListPageRequest = new WordListPageRequest(8, 25);
		String actualResult = wordListPageRequest.toJson();

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void shouldCreateAWordListPageRequestBasedOnJsonData()
			throws JsonParseException, JsonMappingException, IOException {
		String data = "{\"startIndex\":8,\"numberOfElements\":25}";

		ObjectMapper mapper = new ObjectMapper();
		WordListPageRequest request = mapper.readValue(data, WordListPageRequest.class);

		assertEquals(request.getStartIndex(), 8);
		assertEquals(request.getNumberOfElements(), 25);
	}

}
