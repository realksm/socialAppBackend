package com.zosh.service;

import java.util.List;
import java.util.Set;

import com.zosh.exception.UserException;
import com.zosh.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;

	public User registerUser(User user) throws UserException;

	public User findUserById(Integer id) throws UserException;

	public User findUserByEmail(String email) throws UserException;

	public String followUser(Integer reqUserId, Integer followUserId) throws UserException;

	public List<User> findUsersByUserIds(List<Integer> userIds);

	public Set<User> searchUser(String query) throws UserException;

	public User updateUserDetails(User updatedUser, User existingUser) throws UserException;
	
	void updatePassword(User user, String newPassword);
	
    void sendPasswordResetEmail(User user);

}
