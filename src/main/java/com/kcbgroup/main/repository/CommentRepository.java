package com.kcbgroup.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kcbgroup.main.dto.CommentResponse;
import com.kcbgroup.main.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByTutorialId(Long postId);

	@Transactional
	void deleteByTutorialId(long tutorialId);

//	@Query(value="SELECT * FROM comments c WHERE c.tutorial_id=t.id", nativeQuery=true)
//	List<?> findJoin();
	
	
}
