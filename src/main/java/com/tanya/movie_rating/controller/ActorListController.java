package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.actorlist.InitActorListResponseDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchResultDto;
import com.tanya.movie_rating.service.actorlist.ActorListService;

@RestController
@RequestMapping("/api/unauthen/actor-list")
public class ActorListController {
	
	@Autowired
	private ActorListService actorListService;
	
	@GetMapping("/get-init")
	public ResponseEntity<?> getInitActorList() {
		try {
			InitActorListResponseDto result = actorListService.getInitActorList();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> searchActor(@RequestBody ActorSearchConditionDto dto) {
		try {
			ActorSearchResultDto result = actorListService.searchActor(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
