package com.lingvoterra.words.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.lingvoterra.words.dao.Word;

@RunWith(MockitoJUnitRunner.class)
public class WordListPageResponseTest {

	@Test
	public void shouldGenerateJsonRepresentation() throws JsonGenerationException, JsonMappingException, IOException {

		Word word1 = new Word(1, "the", "a", 10);
		Word word2 = new Word(2, "an", "a", 20);
		Word word3 = new Word(3, "language", "n", 5);

		List<Word> wordList = new ArrayList<Word>();
		wordList.add(word1);
		wordList.add(word2);
		wordList.add(word3);

		String expectedResult = "{\"wordList\":[{\"wordId\":1,\"word\":\"the\",\"partOfSpeech\":\"a\"},"
				+ "{\"wordId\":2,\"word\":\"an\",\"partOfSpeech\":\"a\"},"
				+ "{\"wordId\":3,\"word\":\"language\",\"partOfSpeech\":\"n\"}]}";

		WordListPageResponse wordListPageResponse = new WordListPageResponse(wordList);
		String actualResult = wordListPageResponse.toJson();

		System.out.println(actualResult);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void shouldCreateAWordListPageResponseBasedOnJsonData()
			throws JsonParseException, JsonMappingException, IOException {

		String data = "{\"wordList\":[{\"wordId\":1,\"word\":\"the\",\"partOfSpeech\":\"a\"},"
				+ "{\"wordId\":2,\"word\":\"an\",\"partOfSpeech\":\"a\"},"
				+ "{\"wordId\":3,\"word\":\"language\",\"partOfSpeech\":\"n\"}]}";

		ObjectMapper mapper = new ObjectMapper();
		WordListPageResponse wordListPageResponse = mapper.readValue(data, WordListPageResponse.class);

		assertEquals(wordListPageResponse.getWordList().get(0).getWord(), "the");
		assertEquals(wordListPageResponse.getWordList().get(1).getWord(), "an");
		assertEquals(wordListPageResponse.getWordList().get(2).getWord(), "language");

	}
}
