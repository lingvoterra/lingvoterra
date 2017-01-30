package com.lingvoterra.words.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.lingvoterra.words.dao.Word;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class WordListPageResponse {

	@JsonProperty
	public List<Word> wordList = new ArrayList<Word>();

	public WordListPageResponse() {
	}

	public WordListPageResponse(List<Word> wordList) {
		this.wordList = wordList;
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	public String toJson() throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}
