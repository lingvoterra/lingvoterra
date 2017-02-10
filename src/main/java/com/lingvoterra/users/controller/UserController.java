package com.lingvoterra.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingvoterra.users.dao.User;
import com.lingvoterra.users.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam String userLogin, @RequestParam String userPass,
			@RequestParam String userEmail) {
		String result = userLogin + " " + userPass + " " + userEmail;

		User user = new User(userLogin, userPass, userEmail);
		userService.create(user);

		return result;
	}

	@RequestMapping(value = "/finduser", method = RequestMethod.POST)
	@ResponseBody
	public String findUser(@RequestParam String userId) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		int id = Integer.parseInt(userId);
		User user = userService.find(id);

		String jsonInString = mapper.writeValueAsString(user);

		return jsonInString;
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(@RequestParam String userId) {
		int id = Integer.parseInt(userId);
		userService.delete(id);
	}

	// TODO Pass json here in the request body
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestParam String userId, @RequestParam String userLogin, @RequestParam String userPass,
			@RequestParam String userEmail) {
		int id = Integer.parseInt(userId);
		User user = userService.find(id);

		user.setLogin(userLogin);
		user.setPass(userPass);
		user.setEmail(userEmail);

		// Update a user
		userService.update(user);
	}
}
