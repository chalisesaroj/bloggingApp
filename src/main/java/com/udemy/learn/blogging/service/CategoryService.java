package com.udemy.learn.blogging.service;

import java.util.List;

import com.udemy.learn.blogging.payload.CategoryDto;

public interface CategoryService {
	CategoryDto addCategory(CategoryDto categoryDto);
	List<CategoryDto> getAllCategory();
	public List<String> getCategorynames();

}
