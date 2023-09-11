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
public class comment {
	public comment(long id, String name, String email_id, String body) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.body = body;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	
	String name;
	String email_id;
	String body;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pot_id", nullable=false)
	post postcomment;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public post getPost_comment() {
		return postcomment;
	}
	public void setPost_comment(post post_comment) {
		this.postcomment = post_comment;
	}
	@Override
	public String toString() {
		return "comment [id=" + id + ", name=" + name + ", email_id=" + email_id + ", body=" + body + ", post_comment="
				+ postcomment + "]";
	}
	public comment(long id, String name, String email_id, String body, post post_comment) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.body = body;
		this.postcomment = post_comment;
	}
	public comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
