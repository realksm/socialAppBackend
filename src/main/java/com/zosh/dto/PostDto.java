package com.zosh.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zosh.model.Comments;
import com.zosh.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class PostDto {
	

	private Integer id;
	
	private String caption;
	
	private String image;

	private LocalDateTime createdAt;
	
	private UserDto user;
	
	private List<CommentDto> comments=new ArrayList<>();
	
	private List<UserDto> liked= new ArrayList<>(); 
	
	private boolean likedByRequser;
	
	private boolean savedByRequser;
	

}
