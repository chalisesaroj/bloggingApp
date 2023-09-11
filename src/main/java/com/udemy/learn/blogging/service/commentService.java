package com.udemy.learn.blogging.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.udemy.learn.blogging.payload.commentdto;

public interface commentService {
	commentdto createcomment(long post_id,commentdto CommentDto);
	List<commentdto>findcommentbyID(long post_id);
	commentdto updateComment(long post_id,long comment_id,commentdto CommentDto);
	void deleteComment(long post_id, long comment_id);

}
