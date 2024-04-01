package com.softura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softura.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	// get by user
	List<Comment> findByUserName(String user);
}
