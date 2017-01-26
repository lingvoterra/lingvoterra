package com.lingvoterra.dao.words;

public interface WordDao {
	public void create(Word word);

	public Word find(int wordId);

	public void delete(int wordId);

	public void update(Word word);

	/**
	 * Returns the list of words.
	 */
	public WordList getWordList();
}
