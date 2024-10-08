package com.tanya.movie_rating.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("hello", "Welcome to user profile");
		return new ResponseEntity<> (result, HttpStatus.OK);
	}
}
