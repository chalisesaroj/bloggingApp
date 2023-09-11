package com.udemy.learn.blogging.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	 String title;
	 String description;
	String content;
	@OneToMany(mappedBy="postcomment", cascade=CascadeType.ALL)
	List<comment>COMMENT;
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
	
	public post(long id, String title, String description, String content, List<comment> cOMMENT) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		COMMENT = cOMMENT;
	}
	public List<comment> getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(List<comment> cOMMENT) {
		COMMENT = cOMMENT;
	}
	@Override
	public String toString() {
		return "post [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", COMMENT=" + COMMENT + "]";
	}
	public post() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
