package com.udemy.learn.blogging.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.learn.blogging.entity.Post;
import com.udemy.learn.blogging.payload.PostDto;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
List<Post>findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
List<Post>findByCategoryId(long category_id );
}
