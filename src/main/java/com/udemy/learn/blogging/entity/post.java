package com.udemy.learn.blogging.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	 String title;
	 String description;
	String content;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	List<Comment>comment;
	@ManyToOne()
	Category category;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDateTime getCreatedtimes() {
		return dateCreated;
	}
	public void setCreatedtimes(LocalDateTime createdtimes) {
		this.dateCreated = createdtimes;
	}
	public Post(long id, String title, String description, String content, List<Comment> comment, Category category,
			LocalDateTime createdtimes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.comment = comment;
		this.category = category;
		this.dateCreated = createdtimes;
	}
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
}
