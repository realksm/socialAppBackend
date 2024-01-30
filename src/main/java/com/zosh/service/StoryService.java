package com.zosh.service;

import java.util.List;

import com.zosh.exception.StoryException;
import com.zosh.exception.UserException;
import com.zosh.model.Story;

public interface StoryService {

	public Story createStory(Story story,Integer userId) throws UserException;
	
	public List<Story> findStoryByUserId(Integer userId) throws UserException, StoryException;
	
	
}
