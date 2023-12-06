package com.springbootproject.QuestionApp.controllers;

import com.springbootproject.QuestionApp.entities.Post;
import com.springbootproject.QuestionApp.requests.PostCreateRequest;
import com.springbootproject.QuestionApp.requests.PostUpdateRequest;
import com.springbootproject.QuestionApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam Optional<Integer> userID){
        return postService.getPosts(userID);
    }

    @GetMapping("/{postID}")
    public Post getPost(@PathVariable("postID") int postID){
        return postService.getPostById(postID);
    }
    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest postRequest){
        return postService.createPost(postRequest);
    }

    @PutMapping("/{postID}")
    public Post updatePost(@PathVariable("postID") int id, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updatePostById(id, postUpdateRequest);
    }

    @DeleteMapping("/{postID}")
    public String deletePost(@PathVariable("postID") int id){
        return postService.deletePostById(id);
    }




}
