package com.zosh.service;

import java.util.List;

import com.zosh.exception.ChatException;
import com.zosh.exception.MessageException;
import com.zosh.exception.UserException;
import com.zosh.model.Message;
import com.zosh.request.SendMessageRequest;

public interface MessageService  {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
