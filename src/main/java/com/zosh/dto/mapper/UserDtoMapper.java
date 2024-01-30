package com.zosh.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.zosh.dto.PostDto;
import com.zosh.dto.UserDto;
import com.zosh.dto.UserProfileDto;
import com.zosh.model.User;

public class UserDtoMapper {
	
	
	
	public static UserProfileDto reqUserDTO(User user,User reqUser) {
		UserProfileDto userDto =new UserProfileDto();
		List<PostDto> savedPost=PostDtoMapper.toPostDtos(user.getSavedPosts(),reqUser);
		List<PostDto> reposts=PostDtoMapper.toPostDtos(user.getReposts(),reqUser);
		

		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setImage(user.getImage());
		userDto.setBio(user.getBio());
		userDto.setGender(user.getGender());
		userDto.setId(user.getId());
		userDto.setMobile(user.getMobile());
		userDto.setWebsite(user.getWebsite());
		
		userDto.setReposts(reposts);
		userDto.setSavedPosts(savedPost);
		
//		userDto.setStories(null);
//		userDto.setReels(null);
		
//		userDto.setFollower(null);
//		userDto.setFollowing(null);
		
		return userDto;
	}
	
	public static UserDto userDTO(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setImage(user.getImage());;
		
		return userDto;
	}
	
	public static List<UserDto> userDTOS(List<User> list){
		List<UserDto> userDtos = new ArrayList<>();
		
		for(User user : list) {
			UserDto userDto= userDTO(user);
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
