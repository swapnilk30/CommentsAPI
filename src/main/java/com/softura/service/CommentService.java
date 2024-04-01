package com.softura.service;

import java.util.List;

import com.softura.entity.Comment;

public interface CommentService {

	/*
	 * 
	 * 
	 * 3. Search by date: Allow filtering comments by date.
	 * 
	 */
	
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
}
