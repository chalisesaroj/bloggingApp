package com.udemy.learn.blogging.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.learn.blogging.entity.Post;
import com.udemy.learn.blogging.payload.LoginDto;
import com.udemy.learn.blogging.payload.PageResponse;
import com.udemy.learn.blogging.payload.PostDto;
import com.udemy.learn.blogging.payload.PostUpdateResponse;
import com.udemy.learn.blogging.repository.PostRepository;
import com.udemy.learn.blogging.service.PostService;
import com.udemy.learn.blogging.serviceimpl.PostServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private PostService postService;
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/byDate")
	public List<PostDto> findByDate(
	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
	    
	    // Convert the LocalDate values to LocalDateTime with time set to midnight
	    LocalDateTime startDateTime = startDate.atStartOfDay();
	    LocalDateTime endDateTime = endDate.atStartOfDay().plusHours(23).plusMinutes(59).plusSeconds(59);
	    
	    List<Post> listofPostsBetweenDates = postRepository.findByDateCreatedBetween(startDateTime, endDateTime);
	    
	    return listofPostsBetweenDates.stream().map(p -> postService.mapToDto(p)).collect(Collectors.toList());
	}
	/**
	 * This method is used to search the post object.Any post having 
	 * matching keyword in content/description/title of the post will
	 * be returned
	 * @param keyword
	 * @return
	 */
	@GetMapping("/searchPost")
	public List<PostDto> searchByKeyword(
	        @RequestParam String keyword) {
	    
	 
	    return postService.searchbykeyword(keyword);
	}



	/**
	 * This method is used to create a new post
	 * Post object is provided in request Body
	 * @param postDto
	 * @return
	 */

	
	@PostMapping()
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
		return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.OK);
	}

	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param sortBy
	 * @param sortDirection
	 * @return
	 */
	@GetMapping("/allPosts")
	public PageResponse getPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {

		return postService.getAllPost(pageNumber, pageSize, sortBy, sortDirection);
	}
/**
 * This method is used to get post from the id.
 * @param id
 * @return
 */
	@GetMapping("/{id}")
	public PostDto getPostbyId(@PathVariable("id") long id) {

		return postService.getPostById(id);

	}

/**
 * This method is used to update the existing post
 * @param postDto
 * @param id
 * @return
 */
	@PutMapping("/{id}")
	public PostUpdateResponse updatePostbyId(@Valid @RequestBody PostDto postDto, @PathVariable("id") long id) {
		return postService.updatePost(postDto, id);
	}
	

/**
 * 
 * @param id
 * @return
 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable("id") long id) {
	postService.deletePost(id);
		return new ResponseEntity<>("Succesfully Deleted",HttpStatus.OK);
	}

}
