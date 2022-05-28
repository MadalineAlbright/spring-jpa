package com.kcbgroup.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kcbgroup.main.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);

	@SuppressWarnings("unchecked")
	Tutorial save(Tutorial tutorial);

	@Query(value = "SELECT c.id commentid,t.id tutorialid,c.content,t.description,t.published,t.title FROM comments c LEFT JOIN tutorial t ON t.id=c.tutorial_id ORDER BY t.title", nativeQuery = true)
	List<?> findLeftJoin();

	@Query(value = "SELECT c.id commentid,t.id tutorialid,c.content,t.description,t.published,t.title FROM comments c RIGHT JOIN tutorial t ON t.id=c.tutorial_id ORDER BY t.title", nativeQuery = true)
	List<?> findRightJoin();

	// NATIVE SQL-use table name
	@Query(value = "SELECT * FROM tutorial t WHERE t.title =:query", nativeQuery = true)
	List<Tutorial> searchtutorial(String query);

}
