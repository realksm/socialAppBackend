package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
