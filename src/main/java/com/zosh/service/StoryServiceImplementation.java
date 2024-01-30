package com.zosh.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.dto.UserDto;
import com.zosh.exception.StoryException;
import com.zosh.exception.UserException;
import com.zosh.model.Story;
import com.zosh.model.User;
import com.zosh.repository.StoryRepository;
import com.zosh.repository.UserRepository;

@Service
public class StoryServiceImplementation implements StoryService {
	
	@Autowired
	private StoryRepository storyRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Story createStory(Story story, Integer userId) throws UserException {
		
		User user = userService.findUserById(userId);
	

		
		story.setUser(user);
		story.setTimestamp(LocalDateTime.now());
		
		user.getStories().add(story);
		
//		userRepo.save(user);
		return storyRepo.save(story);
		
		
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws UserException,StoryException {
		
		User user = userService.findUserById(userId);
		
		List<Story>  stories = user.getStories();
		
		if(stories.size()==0) {
			throw new StoryException("This user Don't have any Story");
		}
		
		return stories;
	}

}
