package com.udemy.learn.blogging.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.learn.blogging.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User>findByUserNameOrEmail(String userName,String email);
	boolean existsByUserName(String userName);
	boolean existsByEmail(String email);
}
