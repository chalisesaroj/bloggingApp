package com.udemy.learn.blogging.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.learn.blogging.entity.comment;
import com.udemy.learn.blogging.payload.commentdto;
import com.udemy.learn.blogging.service.commentService;
import com.udemy.learn.blogging.serviceimpl.commentServiceImpl;

@RestController
@RequestMapping("/api")
public class commentController {
	@Autowired
	commentServiceImpl commentserviceimplementation;
	@Autowired
	commentService CommentService;
	@PostMapping("/post/{post_id}/comments")
public ResponseEntity<commentdto>createComment(@PathVariable("post_id")long post_id,
		@RequestBody commentdto commentDTO){
			return new ResponseEntity(CommentService.createcomment(post_id, commentDTO),HttpStatus.CREATED);
	
}
@GetMapping("/post/{post_id}/comments")
public List<commentdto>readComment(@PathVariable("post_id")long post_id){
			return CommentService.findcommentbyID(post_id);
}


@PutMapping("/post/{post_id}/comments/{comment_id}")
public commentdto updateComment(@PathVariable("post_id")long post_id,
		@RequestBody commentdto CommentDto,
		@PathVariable("comment_id")long comment_id)
		{
			return CommentService.updateComment(post_id, comment_id, CommentDto);	
		}

@DeleteMapping("/post/{post_id}/comments/{comment_id}")
public ResponseEntity<String> deleteComment(@PathVariable("post_id")long post_id,
		@PathVariable("comment_id")long comment_id)
		{
	CommentService.deleteComment(post_id, comment_id);		
	return new ResponseEntity("Succesfully Deleted",HttpStatus.OK)	;
		}
}
