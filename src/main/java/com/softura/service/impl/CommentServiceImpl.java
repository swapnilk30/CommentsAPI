package com.softura.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softura.entity.Comment;
import com.softura.exception.ResourceNotFoundException;
import com.softura.repository.CommentRepository;
import com.softura.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment saveComment(Comment comment) {

		LocalDateTime currentDate = LocalDateTime.now();

		comment.setDateOfComment(currentDate);

		Comment savedComment = commentRepository.save(comment);

		return savedComment;
	}

	@Override
	public List<Comment> getAll() {
		List<Comment> listOfAllComment = commentRepository.findAll();
		return listOfAllComment;
	}

	@Override
	public Comment update(Long id, Comment comment) {

		// get by id

		Comment oldComment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment Not Found Wiith Given Id !!"));

		// update
		oldComment.setUserName(comment.getUserName());
		oldComment.setText(comment.getText());
		LocalDateTime currentDate = LocalDateTime.now();
		oldComment.setDateOfComment(currentDate);

		// save
		Comment updatedComment = commentRepository.save(oldComment);

		return updatedComment;
	}

	@Override
	public void delete(Long id) {
		// get by id

		Comment oldComment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment Not Found Wiith Given Id !!"));

		commentRepository.delete(oldComment);

	}

	@Override
	public List<Comment> searchByUser(String user) {
		
		
		List<Comment> list = commentRepository.findByUserName(user);
		return list;
	}

}
