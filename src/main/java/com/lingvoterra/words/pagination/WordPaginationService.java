package com.lingvoterra.words.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lingvoterra.words.dao.Word;
import com.lingvoterra.words.dao.WordDao;

@Service
public class WordPaginationService {

	@Autowired
	@Qualifier("wordDao")
	private WordDao wordDao;

	public List<Word> getWordPage(int startIndex, int numberOfElements) {

		// Mock data
		Word word1 = new Word(1, "the", "a", 10);
		Word word2 = new Word(2, "an", "a", 20);
		Word word3 = new Word(3, "language", "n", 5);

		List<Word> wordList = new ArrayList<Word>();
		wordList.add(word1);
		wordList.add(word2);
		wordList.add(word3);

		return wordList;
	}
}
