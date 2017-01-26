package com.lingvoterra.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingvoterra.dao.users.UserDaoImpl;
import com.lingvoterra.dao.words.WordDao;
import com.lingvoterra.dao.words.WordDaoImpl;
import com.lingvoterra.dao.words.WordList;

@Controller
public class WordController {
	static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("lingvoterra");
	private EntityManager entitymanager = emfactory.createEntityManager();
	private WordDao wordDao = new WordDaoImpl(entitymanager);

	@RequestMapping(value = "/getwordlist", method = RequestMethod.POST)
	@ResponseBody
	public String getWordList() throws JsonProcessingException {
		log.info("Getting a word list...");

		ObjectMapper mapper = new ObjectMapper();
		WordList wordList = wordDao.getWordList();

		String jsonInString = mapper.writeValueAsString(wordList.getWordList());

		log.info("The word list was formed.");
		return jsonInString;
	}

}
