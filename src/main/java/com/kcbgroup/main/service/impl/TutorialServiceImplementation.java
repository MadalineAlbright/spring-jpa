package com.kcbgroup.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kcbgroup.main.dto.TutorialResponse;
import com.kcbgroup.main.exception.ResourceNotFoundException;
import com.kcbgroup.main.model.Tutorial;
import com.kcbgroup.main.repository.TutorialRepository;
import com.kcbgroup.main.service.TutorialService;

@Component
public class TutorialServiceImplementation implements TutorialService {

	@Autowired
	private TutorialRepository repo;

	@Override
	public List<Tutorial> searchtutorial(String query) {
		List<Tutorial> tutorials = repo.searchtutorial(query);
		return tutorials;
	}

	@Override
	public ResponseEntity<List<Tutorial>> getAllTutorials(String title) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		if (title == null)
			repo.findAll().forEach(tutorials::add);
		else
			repo.findByTitleContaining(title).forEach(tutorials::add);
		if (tutorials.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Tutorial> getTutorialById(long id) {
		// Check if id exists or not if it exists get the tutorial for that id if not
		// return exception
		Tutorial tutorial = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
		return new ResponseEntity<>(tutorial, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) {
		Tutorial tutorials = repo.save(tutorial);
		return new ResponseEntity<>(tutorials, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Tutorial> updateTutorial(Tutorial tutorial,long id) {
		Tutorial _tutorial = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
		_tutorial.setTitle(tutorial.getTitle());
		_tutorial.setDescription(tutorial.getDescription());
		_tutorial.setPublished(tutorial.isPublished());

		return new ResponseEntity<>(repo.save(_tutorial), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<HttpStatus> deleteTutorial(Long id) {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		repo.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@Override
	public List<Tutorial> findAll() {
		return repo.findAll();
	}

	@Override
	public ResponseEntity<List<Tutorial>> findByPublished() {

		List<Tutorial> tutorials = repo.findByPublished(true);
		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutorialResponse> findLeftJoin() {
		return (List<TutorialResponse>) repo.findLeftJoin();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutorialResponse> findRightJoin() {
		return (List<TutorialResponse>) repo.findRightJoin();
	}
}
