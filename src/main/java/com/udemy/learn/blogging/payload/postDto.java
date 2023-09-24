package com.udemy.learn.blogging.payload;

import java.time.LocalDateTime;
import java.util.List;

import com.udemy.learn.blogging.entity.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {
	private long id;
	@NotEmpty
	@Size(min=2, message ="Post-title must have at least two character")
	private String title;
	@NotEmpty
	@Size(min=2)
	private String description;
	@NotEmpty
	private String content;
	List<CommentDto> listOfComment;
	LocalDateTime datetime;
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public long getId() {
		return id;
	}
	public List<CommentDto> getListOfComment() {
		return listOfComment;
	}
	public void setListOfComment(List<CommentDto> listOfComment) {
		this.listOfComment = listOfComment;
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
	
	
	public PostDto(long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
