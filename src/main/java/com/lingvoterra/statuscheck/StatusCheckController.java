package com.lingvoterra.statuscheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusCheckController {
	private static final String STATUS_IS_OK = "Status is OK";

	@RequestMapping(value = "/v1/statuscheck", method = RequestMethod.GET)
	public ResponseEntity<?> getStatus() {
		try {
			return new ResponseEntity<>(STATUS_IS_OK, HttpStatus.OK);
		} catch (Exception ex) {
			String errorMessage;
			errorMessage = "Error! " + ex;
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
