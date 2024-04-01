package com.softura.service;

import java.time.LocalDate;
import java.util.List;

import com.softura.entity.Comment;

public interface CommentService {

	
	// create
	Comment saveComment(Comment comment);
	
	// Retrieve all comments: Endpoint to fetch all comments.
	List<Comment> getAll();
	
	// update
	Comment update(Long id,Comment comment);
	
	// delete
	
	void delete(Long id);

	
	// Search by username: Allow filtering comments by username.
	List<Comment> searchByUser(String user);
	
	// Search by date: Allow filtering comments by date.
	List<Comment> searchByDate(LocalDate date);
}
