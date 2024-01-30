package com.zosh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.dto.UserDto;
import com.zosh.dto.UserProfileDto;
import com.zosh.dto.mapper.UserDtoMapper;
import com.zosh.exception.UserException;
import com.zosh.model.User;
import com.zosh.response.ApiResponse;

import com.zosh.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/profile")
	public ResponseEntity<UserProfileDto> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException {

		User user = userService.findUserProfileByJwt(jwt);
		user.setPassword(null);
		
		UserProfileDto userDto=UserDtoMapper.reqUserDTO(user,user);

		return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserProfileDto> findUserByIdHandler(@PathVariable Integer id,
			@RequestHeader("Authorization") String jwt) throws UserException{
		User requser = userService.findUserProfileByJwt(jwt);
		User user=userService.findUserById(id);
		
		UserProfileDto userDto=UserDtoMapper.reqUserDTO(user,requser);

		return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/follow/{followUserId}")
	public ResponseEntity<ApiResponse> followUserHandler(@RequestHeader("Authorization") String token, @PathVariable Integer followUserId) throws UserException{
		User reqUser=userService.findUserProfileByJwt(token);
		
		String message=userService.followUser(reqUser.getId(), followUserId);
		ApiResponse res=new ApiResponse("follow",true);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

	
	
	@GetMapping("/search")
	public ResponseEntity<List<UserDto>> searchUserHandler(@RequestParam("q")String query) throws UserException{
		
		Set<User> users=userService.searchUser(query);
		
		List<UserDto> userDtos=UserDtoMapper.userDTOS(new ArrayList<>(users));
		
		return new ResponseEntity<>(userDtos,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserProfileDto> updateUser(@RequestHeader("Authorization") String token, @RequestBody User user) throws UserException{
		
		User reqUser=userService.findUserProfileByJwt(token);
		User updatedUser=userService.updateUserDetails(user, reqUser);
		
		UserProfileDto userDto=UserDtoMapper.reqUserDTO(updatedUser,reqUser);

		return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
		
		
	}
}
