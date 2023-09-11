package com.udemy.learn.blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.learn.blogging.entity.post;
@Repository
public interface postRepository extends JpaRepository<post, Long>{



}
