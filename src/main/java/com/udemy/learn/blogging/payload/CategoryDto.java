package com.udemy.learn.blogging.payload;

import java.util.List;

import com.udemy.learn.blogging.entity.Post;

public class CategoryDto {
	long Id;
	String name;
	String Description;
	List<PostDto>listOfPosts;
	
	public List<PostDto> getListOfPosts() {
		return listOfPosts;
	}
	public void setListOfPosts(List<PostDto> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public CategoryDto(long id, String name, String description) {
		super();
		Id = id;
		this.name = name;
		Description = description;
	}
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}
	

}
