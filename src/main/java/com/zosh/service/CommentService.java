package com.zosh.service;

import com.zosh.exception.CommentException;
import com.zosh.exception.PostException;
import com.zosh.exception.UserException;
import com.zosh.model.Comments;

public interface CommentService {
	
	public Comments createComment(Comments comment,Integer postId,Integer userId) throws PostException, UserException;

	public Comments findCommentById(Integer commentId) throws CommentException;
	public Comments likeComment(Integer CommentId,Integer userId) 
			throws UserException, CommentException;
}
