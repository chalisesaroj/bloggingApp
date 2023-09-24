package com.udemy.learn.blogging.entity;

import org.hibernate.annotations.Cascade;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	public Comment(long id, String name, String emailId, String body) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.body = body;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String name;
	String emailId;
	String body;
	@ManyToOne()
	@JoinColumn(name="post_id", nullable=false)
	Post post;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comment(long id, String name, String emailId, String body, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.body = body;
		this.post = post;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		return "Comment [id=" + id + ", name=" + name + ", emailId=" + emailId + ", body=" + body + ", post=" + post
//				+ "]";
//	}
		
}
