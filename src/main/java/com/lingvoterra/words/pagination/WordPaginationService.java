package com.lingvoterra.words.pagination;

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
		return wordDao.getWordPage(startIndex, numberOfElements);
	}
}
