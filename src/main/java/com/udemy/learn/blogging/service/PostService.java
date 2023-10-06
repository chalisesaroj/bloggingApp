package com.udemy.learn.blogging.service;

import java.util.List;

import com.udemy.learn.blogging.entity.Post;
import com.udemy.learn.blogging.payload.PageResponse;
import com.udemy.learn.blogging.payload.PostDto;
import com.udemy.learn.blogging.payload.PostUpdateResponse;

public interface PostService {
	PostDto createPost(PostDto postDto);
	PostDto getPostById(long id);
PageResponse getAllPost(int pageNumber,int pageSize,String sortBy,String sortDirection);
	PostUpdateResponse updatePost(PostDto postDto,long postId);
	PostDto mapToDto(Post post);
	List<PostDto>findPostByCategoryID(long category_id);
	Post mapToEntity(PostDto postDto);
	List<PostDto>searchbykeyword(String keyword);
	void deletePost(long post_id);
}
