package com.lingvoterra.words.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lingvoterra.words.dao.Word;
import com.lingvoterra.words.dao.WordDao;
import com.lingvoterra.words.dao.WordList;

@Service
public class WordService {

	@Autowired
	@Qualifier("wordDao")
	private WordDao wordDao;

	public WordList getWordList() {
		return wordDao.getWordList();
	}

	public List<Word> getWordPage(int startIndex, int numberOfElements) {
		return wordDao.getWordPage(startIndex, numberOfElements);
	}
}
