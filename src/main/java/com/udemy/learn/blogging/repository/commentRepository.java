package com.udemy.learn.blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.learn.blogging.entity.comment;

public interface commentRepository extends JpaRepository<comment,Long> {
	List<comment>findByPostcommentId(long id);

}
