package com.zosh.service;

import java.util.List;

import com.zosh.exception.UserException;
import com.zosh.model.Reels;
import com.zosh.model.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUsersReel(Integer userId) throws UserException;

}
