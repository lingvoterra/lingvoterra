package com.lingvoterra.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingvoterra.dao.users.User;
import com.lingvoterra.dao.users.UserDao;
import com.lingvoterra.dao.users.UserDaoImpl;

@Controller
public class UserController {

	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("lingvoterra");
	private EntityManager entitymanager = emfactory.createEntityManager();
	private UserDao userDao = new UserDaoImpl(entitymanager);

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam String userLogin, @RequestParam String userPass,
			@RequestParam String userEmail) {
		String result = userLogin + " " + userPass + " " + userEmail;

		System.out.println(userLogin);
		System.out.println(userPass);
		System.out.println(userEmail);

		User user = new User(userLogin, userPass, userEmail);
		userDao.create(user);

		return result;
	}

	@RequestMapping(value = "/finduser", method = RequestMethod.POST)
	@ResponseBody
	public String findUser(@RequestParam String userId) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		int id = Integer.parseInt(userId);
		User user = userDao.find(id);

		String jsonInString = mapper.writeValueAsString(user);

		return jsonInString;
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(@RequestParam String userId) {
		int id = Integer.parseInt(userId);
		userDao.delete(id);

	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUser(@RequestParam String userId, @RequestParam String userLogin,
			@RequestParam String userPass, @RequestParam String userEmail) {
		int id = Integer.parseInt(userId);
		User user = userDao.find(id);

		user.setLogin(userLogin);
		user.setPass(userPass);
		user.setEmail(userEmail);

		// Update a user
		userDao.update(user);

		return null;
	}
}
