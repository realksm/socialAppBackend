package com.zosh.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.zosh.dto.ChatDto;
import com.zosh.dto.MessageDto;
import com.zosh.dto.UserDto;

import com.zosh.model.Chat;
import com.zosh.model.User;
import com.zosh.utils.ChatUtil;

public class ChatDtoMapper {
	
	public static ChatDto toChatDto(Chat chat,User user) {
		
		UserDto userDto=UserDtoMapper.userDTO(chat.getCreated_by());
		List<MessageDto> messageDtos=MessageDtoMapper.toMessageDtos(chat.getMessages());
		List<UserDto> userDtos=UserDtoMapper.userDTOS(chat.getUsers());
	
		
		ChatDto chatDto=new ChatDto();
		chatDto.setId(chat.getId());
		chatDto.setChat_image(chat.getChat_image());
		chatDto.setChat_name(ChatUtil.chatName(chat, user));
		chatDto.setCreated_by(userDto);
		chatDto.setIs_group(chat.getIs_group());
		chatDto.setMessages(messageDtos);
		chatDto.setUsers(userDtos);
		
		
		
		return chatDto;
	}
	
	public static List<ChatDto> toChatDtos(List<Chat> chats,User user){
		
		List<ChatDto> chatDtos=new ArrayList<>();
		
		for(Chat chat:chats) {
			ChatDto chatDto=toChatDto(chat,user);
			chatDtos.add(chatDto);
		}
		
		return chatDtos;
	}

}
