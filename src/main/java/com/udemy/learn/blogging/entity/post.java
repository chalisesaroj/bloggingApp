package com.udemy.learn.blogging.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	 String title;
	 String description;
	 @Column(length = 50000)
	String content;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	List<Comment>comment;
	@ManyToOne()
	Category category;
	@CreationTimestamp
	private LocalDateTime dateCreated;	
}
