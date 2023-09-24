package com.udemy.learn.blogging.payload;

public class CommentDto {
	long id;
	String email_id;
	String name;
	String body;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "commentdto [id=" + id + ", email_id=" + email_id + ", name=" + name + ", body=" + body + "]";
	}
	public CommentDto(long id, String email_id, String name, String body) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.name = name;
		this.body = body;
	}

}
