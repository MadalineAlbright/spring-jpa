package com.kcbgroup.main.service;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kcbgroup.main.model.Comment;

@Service
public interface CommentsService {

	ResponseEntity<HttpStatus> deleteComment(long id);
	ResponseEntity<List<Comment>> getAllCommentsByTutorialId(long id);
	ResponseEntity<Comment> getCommentsByCommentId(long id);
	ResponseEntity<Comment> createComment(long tutorialId,Comment commentRequest);
	ResponseEntity<Comment> updateComment(long id,Comment comment);
	ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(long id);
//	List<?>findJoin();
	
	
}
