package com.kcbgroup.main.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kcbgroup.main.dto.TutorialResponse;
import com.kcbgroup.main.model.Tutorial;

@Service
public interface TutorialService {

	List<Tutorial> findAll();

	List<Tutorial> searchtutorial(String query);

	ResponseEntity<List<Tutorial>> getAllTutorials(String title);

	ResponseEntity<Tutorial> getTutorialById(long id);

	ResponseEntity<Tutorial> createTutorial(Tutorial tutorial);

	ResponseEntity<Tutorial> updateTutorial(Tutorial tutorial, long id);

	ResponseEntity<HttpStatus> deleteTutorial(Long id);

	ResponseEntity<HttpStatus> deleteAllTutorials();

	ResponseEntity<List<Tutorial>> findByPublished();

	List<TutorialResponse> findLeftJoin();

	List<TutorialResponse> findRightJoin();

}
