package com.softura.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softura.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	// get by user
	List<Comment> findByUserName(String user);
	
	// search by date
	
	@Query(value = "SELECT * FROM comments WHERE DATE(dateofcomment) = :date", nativeQuery = true)
    List<Comment> findByDateOfComment(@Param("date") LocalDate date);
}
