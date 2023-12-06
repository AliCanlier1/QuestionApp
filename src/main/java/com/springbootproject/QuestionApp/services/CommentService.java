package com.springbootproject.QuestionApp.services;


import com.springbootproject.QuestionApp.entities.Comment;
import com.springbootproject.QuestionApp.entities.Post;
import com.springbootproject.QuestionApp.entities.User;
import com.springbootproject.QuestionApp.repos.CommentRepository;
import com.springbootproject.QuestionApp.requests.CommentCreateRequest;
import com.springbootproject.QuestionApp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    private PostService postService;

    private UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService){
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<Comment> getComments(Optional<Integer> postID, Optional<Integer> userID) {
        if(postID.isPresent() && userID.isPresent()){
            return commentRepository.getByPostandUserID(postID.get(), userID.get());
        }
        else if(postID.isPresent()){
            return commentRepository.getByPostID(postID.get());
        }
        else if(userID.isPresent()){
            return commentRepository.getByUserID(userID.get());
        }
        else{
            return commentRepository.findAll();
        }
    }

    public Comment getCommentById(int commentID) {
        return commentRepository.findById(commentID).orElse(null);
    }


    public Comment createComment(CommentCreateRequest request) {
        User user = userService.getUserById(request.getUserId());
        Post post = postService.getPostById(request.getPostId());

        if(user == null || post == null){
            return null;
        }
        else{
            Comment comment = new Comment(request.getId(), post, user, request.getText());
            commentRepository.save(comment);
            return comment;
        }

    }

    public Comment updateCommentById(int commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment updatedComment = comment.get();
            updatedComment.setText(request.getText());
            commentRepository.save(updatedComment);
            return updatedComment;
        }
        else{
            return null;
        }
    }

    public String deleteCommentById(int commentID) {
        Optional<Comment> comment = commentRepository.findById(commentID);
        if(comment.isPresent()){
            Comment deletedComment = comment.get();
            commentRepository.delete(deletedComment);
            return "The comment which id is: "+ deletedComment.getId()+" have been deleted.";
        }
        else{
            return null;
        }

    }
}
