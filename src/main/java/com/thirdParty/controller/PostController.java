package com.thirdParty.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thirdParty.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<Map<String, Object>>> getPost(){
		
		List<Map<String, Object>> posts= postService.getPost();
		
		return new ResponseEntity<List<Map<String,Object>>>(posts, HttpStatus.OK);
		
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Object> getPostById( @PathVariable Integer id){
		
		Object posts= postService.getPostById(id);
		
		return new ResponseEntity<Object>(posts, HttpStatus.OK);
		
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Map<String, Object>> insertPost(@RequestBody Map<String, Object> payload){
	    Map<String, Object> insertNewPost = postService.insertPost(payload);
	    return new ResponseEntity<>(insertNewPost, HttpStatus.OK);
	}
	
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Map<String, Object>> updatePost( @PathVariable Integer id, @RequestBody Map<String, Object> payload){
		
		Map<String, Object> posts= postService.updatePost(id, payload);
		
		return new ResponseEntity<Map<String, Object>>(posts, HttpStatus.OK);
		
	}


}
