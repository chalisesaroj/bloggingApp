package com.udemy.learn.blogging.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemy.learn.blogging.entity.Post;
import com.udemy.learn.blogging.payload.PostDto;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
List<Post>findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
List<Post>findByCategoryId(long category_id );
@Query("SELECT p FROM Post p WHERE "
        + "p.content LIKE CONCAT('%', :query, '%') OR "
        + "p.description LIKE CONCAT('%', :query, '%') OR "
        + "p.title LIKE CONCAT('%', :query, '%')")

List<Post>searchPost(String query);
}
