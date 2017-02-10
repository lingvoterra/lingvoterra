package com.lingvoterra.words.dao;

import java.util.List;

public interface WordDao {
	public void create(Word word);

	public Word find(int wordId);

	public void delete(int wordId);

	public void update(Word word);

	/**
	 * Returns the list of words.
	 */
	public WordList getWordList();

	/**
	 * Returns words per a page
	 *
	 * @param startIndex
	 *            - index to start page
	 * @param numberOfElements
	 *            - number of words in a page
	 * @return list of words
	 */
	public List<Word> getWordPage(int startIndex, int numberOfElements);

}
