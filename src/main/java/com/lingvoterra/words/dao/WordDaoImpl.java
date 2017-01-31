package com.lingvoterra.words.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.lingvoterra.exception.BadDataException;

public class WordDaoImpl implements WordDao {

	static Logger log = Logger.getLogger(WordDaoImpl.class.getName());
	private EntityManager entitymanager;

	public WordDaoImpl(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@Override
	public void create(Word word) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(word);
		entitymanager.getTransaction().commit();
	}

	@Override
	public Word find(int wordId) {
		entitymanager.getTransaction().begin();
		Word word = entitymanager.find(Word.class, wordId);
		entitymanager.getTransaction().commit();
		return word;
	}

	@Override
	public void delete(int wordId) {
		entitymanager.getTransaction().begin();
		Word word = entitymanager.find(Word.class, wordId);
		entitymanager.remove(word);
		entitymanager.getTransaction().commit();
	}

	@Override
	public void update(Word newWord) {
		entitymanager.getTransaction().begin();
		Word word = entitymanager.find(Word.class, newWord.getWordId());
		word = newWord;
		entitymanager.getTransaction().commit();
	}

	@Override
	public WordList getWordList() {

		WordList wordList = new WordList();
		Query query = entitymanager.createNativeQuery("SELECT wordId, word, partOfSpeech FROM word", Word.class);
		List<Word> list = query.getResultList();

		for (Object item : list) {
			if (item instanceof Word) {
				wordList.getWordList().add((Word) item);
			}
		}
		return wordList;
	}

	@Override
	public List<Word> getWordPage(int startIndex, int numberOfElements) {

		if (startIndex < 0 || numberOfElements <= 0) {
			throw new BadDataException("Bad data for word page. Start index should be >=0");
		} else if (numberOfElements <= 0) {
			throw new BadDataException(
					"Bad data for word page. Number of elements for a pagination should be positive values!");
		}

		List<Word> wordList = new ArrayList<Word>();

		Query query = entitymanager.createNativeQuery(
				"SELECT wordId, word, partOfSpeech FROM word LIMIT " + startIndex + ", " + numberOfElements,
				Word.class);

		List<Word> list = query.getResultList();

		for (Object item : list) {
			if (item instanceof Word) {
				wordList.add((Word) item);
			}
		}
		return wordList;
	}

}
