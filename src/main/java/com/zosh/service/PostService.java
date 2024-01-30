package com.zosh.service;

import java.util.List;

import com.zosh.exception.PostException;
import com.zosh.exception.UserException;
import com.zosh.model.Post;

public interface PostService {

	public Post createPost(Post post, Integer userId) throws UserException, PostException;
	
	public String deletePost(Integer postId, Integer userId) throws UserException,PostException;
	
	public List<Post> findPostByUserId(Integer userId) throws UserException;
	
	public Post findePostById(Integer postId) throws PostException;
	
	public List<Post> findAllPost() throws PostException;
	
	public Post savedPost(Integer postId,Integer userId) throws PostException, UserException;
	
	public Post likePost(Integer postId ,Integer userId) throws UserException, PostException;
	
}
