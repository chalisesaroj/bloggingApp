package com.udemy.learn.blogging.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.learn.blogging.entity.Role;
import com.udemy.learn.blogging.entity.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
Optional<Role>findByRole(String role);
}
