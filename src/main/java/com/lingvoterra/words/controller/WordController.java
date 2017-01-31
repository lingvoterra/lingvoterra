package com.lingvoterra.words.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingvoterra.dao.users.UserDaoImpl;
import com.lingvoterra.words.dao.Word;
import com.lingvoterra.words.dao.WordDao;
import com.lingvoterra.words.dao.WordList;
import com.lingvoterra.words.pagination.WordPaginationService;

@Controller
public class WordController {
	static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManagerFactory emfactory;

	@Autowired
	@Qualifier("entityManager")
	private EntityManager entitymanager;

	@Autowired
	@Qualifier("wordDao")
	private WordDao wordDao;

	@Autowired
	private WordPaginationService wordPaginationService;

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

	@RequestMapping(value = "/getwordlistpage", method = RequestMethod.POST)
	@ResponseBody
	public String getWordListPage(@RequestBody String wordListPageRequestData) throws IOException {
		log.info("Getting a word list page...");

		ObjectMapper mapper = new ObjectMapper();

		WordListPageRequest wordListRequest = mapper.readValue(wordListPageRequestData, WordListPageRequest.class);

		// TODO Call a service to get the words for the requested page
		// ....

		// Prepare response

		List<Word> wordList = wordPaginationService.getWordPage(wordListRequest.getStartIndex(),
				wordListRequest.getNumberOfElements());

		WordListPageResponse wordListPageResponse = new WordListPageResponse(wordList);
		log.info("The word list page was formed.");
		return wordListPageResponse.toJson();

	}

}
