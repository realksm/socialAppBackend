package com.zosh.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ChatDto {

	private Integer id;
	private String chat_name;
	private String chat_image;
	
	private Boolean is_group;
	
	private List<UserDto> admins= new ArrayList<>();
	
	private UserDto created_by;

	private List<UserDto> users = new ArrayList<>();
	
	private List<MessageDto> messages=new ArrayList<>();

	
	
	
}
