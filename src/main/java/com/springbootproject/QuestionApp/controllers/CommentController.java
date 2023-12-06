package com.springbootproject.QuestionApp.controllers;

import com.springbootproject.QuestionApp.entities.Comment;
import com.springbootproject.QuestionApp.requests.CommentCreateRequest;
import com.springbootproject.QuestionApp.requests.CommentUpdateRequest;
import com.springbootproject.QuestionApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments(@RequestParam Optional<Integer> postID, @RequestParam Optional<Integer> userID){
        return commentService.getComments(postID, userID);
    }
    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable("commentId") int commentID){
        return commentService.getCommentById(commentID);
    }

    @PostMapping
    public Comment createPost(@RequestBody CommentCreateRequest request){
        return commentService.createComment(request);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable("commentId") int commentID, @RequestBody CommentUpdateRequest request){
        return commentService.updateCommentById(commentID, request);
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable("commentId") int commentID){
        return commentService.deleteCommentById(commentID);
    }
















}
