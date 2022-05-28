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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kcbgroup.main.dto.TutorialResponse;
import com.kcbgroup.main.model.Tutorial;
import com.kcbgroup.main.service.TutorialService;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class TutorialController {

	@Autowired
	TutorialService tutorialservice;

	@GetMapping("/tutorialsall")
	public List<Tutorial> getAll() {
		return tutorialservice.findAll();
	}

	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		return tutorialservice.getAllTutorials(title);
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
		return tutorialservice.getTutorialById(id);
	}

	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		return tutorialservice.createTutorial(tutorial);
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		return tutorialservice.updateTutorial(tutorial, id);
	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		return tutorialservice.deleteTutorial(id);
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		return tutorialservice.deleteAllTutorials();
	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		return tutorialservice.findByPublished();
	}

	@GetMapping("/getleftjoin")
	public List<TutorialResponse> findLeftJoin() {
		return tutorialservice.findLeftJoin();
	}

	@GetMapping("/getRightjoin")
	public List<TutorialResponse> findRightJoin() {
		return tutorialservice.findRightJoin();
	}

	@GetMapping("/search")
	public List<Tutorial> searchtutorial(@RequestParam(value = "query") String query) {
		return tutorialservice.searchtutorial(query);
	}

}
