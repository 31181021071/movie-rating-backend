package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchResultDto;
import com.tanya.movie_rating.dto.directorlist.InitDirectorListResponseDto;
import com.tanya.movie_rating.service.directorlist.DirectorListService;

@RestController
@RequestMapping("/api/unauthen/director-list")
public class DirectorListController {
	
	@Autowired
	private DirectorListService directorListService;
	
	@GetMapping("/get-init")
	public ResponseEntity<?> getInitDirectorList() {
		try {
			InitDirectorListResponseDto result = directorListService.getInitDirectorList();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> searchDirector(@RequestBody DirectorSearchConditionDto dto) {
		try {
			DirectorSearchResultDto result = directorListService.searchDirector(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
