package com.kcbgroup.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.kcbgroup.main.exception.ResourceNotFoundException;
import com.kcbgroup.main.model.Comment;
import com.kcbgroup.main.repository.CommentRepository;
import com.kcbgroup.main.repository.TutorialRepository;
import com.kcbgroup.main.service.CommentsService;

@Component
public class CommentServiceImplementation implements CommentsService {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private TutorialRepository tutorialRepository;

	@Override
	public ResponseEntity<HttpStatus> deleteComment(long id) {
		commentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable("tutorialId") long tutorialId) {
		if (!tutorialRepository.existsById(tutorialId)) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
		}
		List<Comment> comments = commentRepository.findByTutorialId(tutorialId);
		return new ResponseEntity<>(comments, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Comment> getCommentsByCommentId(long id) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Comment> createComment(long tutorialId, Comment commentRequest) {
		Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
			commentRequest.setTutorial(tutorial);
			return commentRepository.save(commentRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
		return new ResponseEntity<>(comment, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Comment> updateComment(long id, Comment commentRequest) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));
		comment.setContent(commentRequest.getContent());
		return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(long tutorialId) {
		if (!tutorialRepository.existsById(tutorialId)) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
		}
		commentRepository.deleteByTutorialId(tutorialId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



}
