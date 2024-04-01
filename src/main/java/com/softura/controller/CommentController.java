package com.softura.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softura.entity.Comment;
import com.softura.helper.ApiResponseMessage;
import com.softura.repository.CommentRepository;
import com.softura.service.CommentService;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	// create comment
	// POST http://localhost:8080/api/v2/comments
	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
		
		Comment commentCreated = commentService.saveComment(comment);
		
		return new ResponseEntity<Comment>(commentCreated,HttpStatus.CREATED);
	}
	
	// get All Comments
	// GET http://localhost:8080/api/v2/comments
	@GetMapping
	public ResponseEntity<List<Comment>> getAllComment(){
		
		List<Comment> list = commentService.getAll();
		
		return new ResponseEntity<List<Comment>>(list,HttpStatus.OK);
	}
	
	// update Comment
	// PUT http://localhost:8080/api/v2/comments/1
	@PutMapping("/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment){
		Comment updatedComment = commentService.update(id, comment);
		return ResponseEntity.ok(updatedComment);
	}
	
	// delete By id
	
	@DeleteMapping("/{id}")
	// DELETE http://localhost:8080/api/v2/comments/1
	public ResponseEntity<ApiResponseMessage> deleteComment(@PathVariable Long id){
		
		commentService.delete(id);
		ApiResponseMessage responseMessage = new ApiResponseMessage("Comment Deleted Successfully !!",HttpStatus.OK);
		return ResponseEntity.ok(responseMessage);
	}
	
	// search by userNAme
	// GET http://localhost:8080/api/v2/comments/search?username=user2
	@GetMapping("/search")
	public ResponseEntity<List<Comment>> getCommentsByUserName(@RequestParam("username") String userName){
		
		List<Comment> searchByUser = commentService.searchByUser(userName);
		
		return ResponseEntity.ok(searchByUser);
	}
	
	@GetMapping("/search/date")
	// http://localhost:8080/api/v2/comments/search/date?date=2024-04-03
	public ResponseEntity<List<Comment>> getCommentsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		
		List<Comment> searchByDate = commentService.searchByDate(date);
		
		return ResponseEntity.ok(searchByDate);
	}
	
}
