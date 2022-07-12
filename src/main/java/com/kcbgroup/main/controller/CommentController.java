package com.kcbgroup.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcbgroup.main.model.Comment;
import com.kcbgroup.main.service.CommentsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentsService commentsService;

	@GetMapping("/tutorials/{tutorialId}/comments")
	public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(
			@PathVariable(value = "tutorialId") Long tutorialId) {
		return commentsService.getAllCommentsByTutorialId(tutorialId);
	}

	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> getCommentsByCommentId(@PathVariable(value = "id") Long id) {
		return commentsService.getCommentsByCommentId(id);
	}

	@PostMapping("/tutorials/{tutorialId}/comments")
	public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
			@RequestBody Comment commentRequest) {
		return commentsService.createComment(tutorialId, commentRequest);
	}

	@PutMapping("/comments/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
		return commentsService.updateComment(id, commentRequest);
	}

	@DeleteMapping("/comments/{id}")
	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
		return commentsService.deleteComment(id);
	}

	@DeleteMapping("/tutorials/{tutorialId}/comments")
	public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(
			@PathVariable(value = "tutorialId") Long tutorialId) {
		return commentsService.deleteAllCommentsOfTutorial(tutorialId);
	}


}