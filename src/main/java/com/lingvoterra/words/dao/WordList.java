package com.lingvoterra.words.dao;

import java.util.ArrayList;
import java.util.List;

// TODO See WordListPageResponse seems that dublicates.
public class WordList {

	public List<Word> wordList = new ArrayList<Word>();

	public WordList() {
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}
}