package com.zosh.request;

import java.util.List;

import lombok.Data;

@Data
public class GroupChatRequest {
	
	private List<Integer> userIds;
	private String chat_name;
	private String chat_image;
	
	
}
