package com.zosh.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Chats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String chat_name;
	private String chat_image;
	
	private Boolean is_group;
	
	@ManyToOne
	private User created_by;
	
	@ManyToMany
	private List<User> users = new ArrayList<>();
 
//	@JsonIgnore
	@OneToMany( mappedBy = "chat")
	private List<Message> messages = new ArrayList<>();

	
}
