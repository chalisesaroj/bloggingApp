package com.udemy.learn.blogging.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.udemy.learn.blogging.entity.comment;
import com.udemy.learn.blogging.entity.post;
import com.udemy.learn.blogging.payload.commentdto;
import com.udemy.learn.blogging.repository.commentRepository;
import com.udemy.learn.blogging.repository.postRepository;
import com.udemy.learn.blogging.service.commentService;
@Service
public class commentServiceImpl implements commentService{
@Autowired
	private commentRepository cummentrepository;
@Autowired
private postRepository POSTREPOSITORY;
	@Override
	public commentdto createcomment(long post_id, commentdto CommentDto) {
		// get post object by ID
		Optional<post> POST=POSTREPOSITORY.findById(post_id);
		if(POST.isPresent()) {
			post POSTFOUND=POST.get();
			comment COMMENT=maptoentity(CommentDto);
			COMMENT.setPost_comment(POSTFOUND);
			comment Newcomment=cummentrepository.save(COMMENT);
			return maptodto(Newcomment);
		}else return null;
		
	
	}
	///Converting entity to dto
	private commentdto maptodto(comment Comment) {
	return new commentdto(Comment.getId(),Comment.getEmail_id(),Comment.getName(),Comment.getBody());	
	}
	
	//Converting dto to entity
	
	private comment maptoentity(commentdto Commentdto) {
		return new comment(Commentdto.getId(),Commentdto.getName(),Commentdto.getEmail_id(),Commentdto.getBody());
		}
	@Override
	public List<commentdto> findcommentbyID(long post_id) {
		List<comment>listofcomment=cummentrepository.findByPostcommentId(post_id);
			
		return listofcomment.stream().map(comment->maptodto(comment)).collect(Collectors.toList());
	}
	@Override
	public commentdto updateComment(long post_id, long comment_id, commentdto CommentDto) {
		comment COMMENT=cummentrepository.findById(comment_id).get();
		post POST=POSTREPOSITORY.findById(post_id).get();
COMMENT.setBody(CommentDto.getBody());
COMMENT.setEmail_id(CommentDto.getEmail_id());
COMMENT.setName(CommentDto.getName());
comment newComment=cummentrepository.save(COMMENT);

		return maptodto(newComment);
	}
	@Override
	public void deleteComment(long post_id, long comment_id) {
		comment COMMENT=cummentrepository.findById(comment_id).get();
		post POST=POSTREPOSITORY.findById(post_id).get();
		cummentrepository.delete(COMMENT);
		
	}
}
