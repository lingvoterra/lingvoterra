package com.lingvoterra.dao.words;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wordId;

	@JsonProperty
	private String word;

	@JsonProperty
	private String partOfSpeech;

	public Word() {
	}

	public Word(int wordId, String word, String partOfSpeech, int frequency) {
		super();
		this.wordId = wordId;
		this.word = word;
		this.partOfSpeech = partOfSpeech;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
}
