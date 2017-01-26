package com.lingvoterra.dao.words;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

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

		/*
		 * // TODO Mock - replace by the database call
		 * wordList.getWordList().add(new Word(1, "apple", "n", 1));
		 * wordList.getWordList().add(new Word(2, "orange", "n", 2));
		 */

		WordList wordList = new WordList();
		Query query = entitymanager.createNativeQuery("SELECT wordId, word, partOfSpeech FROM word", Word.class);
		List<Word> list = query.getResultList();

		log.info(list);

		for (Object item : list) {
			if (item instanceof Word) {
				wordList.getWordList().add((Word) item);
			}
		}

		return wordList;

	}
}
