package com.softura.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "By", nullable = false, length = 255)
	private String userName;

	@Column(name = "Text", nullable = false, columnDefinition = "TEXT")
	private String text;

	@Column(name = "dateofcomment", nullable = false)
	private LocalDateTime dateOfComment;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateOfComment() {
		return dateOfComment;
	}

	public void setDateOfComment(LocalDateTime dateOfComment) {
		this.dateOfComment = dateOfComment;
	}

	public Comment(String userName, String text, LocalDateTime dateOfComment) {
		super();
		this.userName = userName;
		this.text = text;
		this.dateOfComment = dateOfComment;
	}

	
	

}
