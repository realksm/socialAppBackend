package com.zosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.dto.MessageDto;
import com.zosh.dto.mapper.MessageDtoMapper;
import com.zosh.exception.ChatException;
import com.zosh.exception.MessageException;
import com.zosh.exception.UserException;
import com.zosh.model.Message;
import com.zosh.model.User;
import com.zosh.request.SendMessageRequest;
import com.zosh.response.ApiResponse;
import com.zosh.service.MessageService;
import com.zosh.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<MessageDto> sendMessageHandler(
			@RequestHeader("Authorization")String jwt,  
			@RequestBody SendMessageRequest req) throws UserException, ChatException{
		
		User reqUser=userService.findUserProfileByJwt(jwt);
		
		req.setUserId(reqUser.getId());
		
		Message message=messageService.sendMessage(req);
		
		MessageDto messageDto=MessageDtoMapper.toMessageDto(message);
		
		return new ResponseEntity<>(messageDto,HttpStatus.OK);
	}
	
	@GetMapping("/chat/{chatId}")
	public ResponseEntity<List<MessageDto>> getChatsMessageHandler(@PathVariable Integer chatId) throws ChatException{
		
		List<Message> messages=messageService.getChatsMessages(chatId);
		
		List<MessageDto> messageDtos=MessageDtoMapper.toMessageDtos(messages);
		
		return new ResponseEntity<List<MessageDto>>(messageDtos,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{messageId}")
	public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId) throws MessageException{
		
		messageService.deleteMessage(messageId);
		
		ApiResponse res=new ApiResponse("message deleted successfully",true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
