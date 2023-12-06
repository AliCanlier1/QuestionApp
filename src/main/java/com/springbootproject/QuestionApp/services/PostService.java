package com.springbootproject.QuestionApp.services;

import com.springbootproject.QuestionApp.entities.Post;
import com.springbootproject.QuestionApp.entities.User;
import com.springbootproject.QuestionApp.repos.PostRepository;
import com.springbootproject.QuestionApp.requests.PostCreateRequest;
import com.springbootproject.QuestionApp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getPosts(Optional<Integer> userID) {
        if (userID.isPresent()) {
            return postRepository.findByUserId(userID.get());
        } else {
            return postRepository.findAll();
        }
    }

    public Post getPostById(int postID) {
        return postRepository.findById(postID).orElse(null);
    }


    public Post createPost(PostCreateRequest postRequest) {
        User user = userService.getUserById(postRequest.getUserId());
        if (user == null) {
            return null;
        } else {
            Post post = new Post(postRequest.getId(), user, postRequest.getTitle(), postRequest.getText());
            postRepository.save(post);
            return post;
        }
    }

    public Post updatePostById(int id, PostUpdateRequest postUpdateRequest) {
        Optional<Post> oldPost = postRepository.findById(id);
        if (oldPost.isPresent()) {
            Post post = oldPost.get();
            post.setText(postUpdateRequest.getText());
            post.setTitle(postUpdateRequest.getTitle());
            postRepository.save(post);
            return post;
        } else {
            return null;
        }
    }

    public String deletePostById(int id) {
        postRepository.deleteById(id);
        return "The post which id is " + id + " have been deleted.";
    }
}
