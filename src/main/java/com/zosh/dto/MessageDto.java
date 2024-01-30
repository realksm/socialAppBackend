package com.zosh.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDto {

	private String content;
	private String image;
	private Integer id;
	private LocalDateTime timeStamp;
	private Boolean is_read;
	private UserDto user;
	private ChatDto chat;
	
	
	
	
	
}
