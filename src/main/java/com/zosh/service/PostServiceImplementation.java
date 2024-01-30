package com.zosh.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.dto.UserDto;
import com.zosh.exception.PostException;
import com.zosh.exception.UserException;
import com.zosh.model.Post;
import com.zosh.model.User;
import com.zosh.repository.PostRepository;
import com.zosh.repository.UserRepository;


@Service
public class PostServiceImplementation implements PostService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;

	
	@Override
	public Post createPost(Post post, Integer userId) throws UserException   {
		
		User user = userService.findUserById(userId);
		

		Post newPost =new Post();
		newPost.setUser(user);
		newPost.setCaption(post.getCaption());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		Post createdPost =postRepo.save(newPost);
			
		
		return createdPost;
	}

	
	@Override
	public List<Post> findPostByUserId(Integer userId) throws UserException {
		
		List<Post> posts=postRepo.findByUserId(userId);
		
		
			return posts;
		
	}


	@Override
	public Post findePostById(Integer postId) throws PostException {
		Optional<Post> opt = postRepo.findById(postId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new PostException("Post not exist with id: "+postId);
	}


	@Override
	public List<Post> findAllPost() throws PostException {
		List<Post> posts = postRepo.findAllByOrderByCreatedAtDesc();
		return posts;
	}


	@Override
	public Post likePost(Integer postId, Integer userId) throws UserException, PostException  {
		// TODO Auto-generated method stub
		
		User user= userService.findUserById(userId);
		
		Post post=findePostById(postId);
		
		if(!post.getLiked().contains(user)) {
			post.getLiked().add(user);
		}
		else {
			post.getLiked().remove(user);
		}
	
		return postRepo.save(post);
		
		
	}

	


	@Override
	public String deletePost(Integer postId, Integer userId) throws UserException, PostException {
		// TODO Auto-generated method stub
		
		Post post =findePostById(postId);
		
		User user=userService.findUserById(userId);
		System.out.println(post.getUser().getId()+" ------ "+user.getId());
		if(post.getUser().getId().equals(user.getId())) {
			System.out.println("inside delete");
			postRepo.deleteById(postId);
		
		return "Post Deleted Successfully";
		}
		
		
		throw new PostException("You Dont have access to delete this post");
		
	}




	@Override
	public Post savedPost(Integer postId, Integer userId) throws PostException, UserException {
		
		Post post=findePostById(postId);
		User user=userService.findUserById(userId);
		if(!user.getSavedPosts().contains(post)) {
			user.getSavedPosts().add(post);
			
			
		}
		else {
			user.getSavedPosts().remove(post);
			
		}
		userRepo.save(user);
		return post;
		
	}


	
	

}
