package com.udemy.learn.blogging.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.udemy.learn.blogging.entity.Post;
import com.udemy.learn.blogging.payload.PageResponse;
import com.udemy.learn.blogging.payload.PostDto;
import com.udemy.learn.blogging.repository.PostRepository;
import com.udemy.learn.blogging.service.CommentService;
import com.udemy.learn.blogging.service.PostService;
@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostRepository postRepository;
@Autowired
CommentService commentService;
	@Override
	public PostDto createPost(PostDto postDto) {
		Post post =mapToEntity(postDto);
		Post newPost=postRepository.save(post);
		return mapToDto(newPost);
	}
	@Override
	public List<PostDto>findPostByCategoryID(long category_id){
		List<Post> listOfPosts=postRepository.findByCategoryId(category_id);
		return listOfPosts.stream().map(p->this.mapToDto(p)).collect(Collectors.toList());
		
		
	}
	@Override
	public PostDto mapToDto(Post post) {
		PostDto postDto=new PostDto();
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		postDto.setTitle(post.getTitle());
		postDto.setId(post.getId());
		postDto.setDatetime(post.getCreatedtimes());
	postDto.setListOfComment(commentService.findCommentByID(post.getId()));
		return postDto;
	}
	@Override
	public Post mapToEntity(PostDto postDto) {
		Post post=new Post();
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setId(postDto.getId());
		return post;
	}
	@Override
	public PostDto getPostById(long id) {
		Post post=postRepository.findById(id).orElseThrow();
		return mapToDto(post);
	}
	
	@Override
	public PageResponse getAllPost(int pageNumber, int pageSize, String sortBy,String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable=PageRequest.of(pageNumber, pageSize, sort );
		Page<Post> page=postRepository.findAll(pageable);
		List<Post>listOfPost=page.getContent();
		PageResponse pageResponse =new PageResponse();
		pageResponse.setContents(listOfPost.stream().map(post -> mapToDto(post)).collect(Collectors.toList())) ;
		pageResponse.setLast(page.isLast());
		pageResponse.setNoOfElements(page.getNumberOfElements());
		pageResponse.setNoOfPage(page.getTotalPages());
		pageResponse.setPageSize(page.getSize());
		return pageResponse;
	
	}
	@Override
	public PostDto updatePost(PostDto postDto, long postId) {
		Post post=postRepository.findById(postId).orElseThrow();
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setTitle(postDto.getTitle());
		Post updatedPost=postRepository.save(post);
		return mapToDto(updatedPost);

	}
	
}
