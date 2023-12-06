package com.springbootproject.QuestionApp.requests;

public class CommentCreateRequest {

    private int id;

    private int postId;

    private int userId;

    private String text;

    public CommentCreateRequest(){}

    public CommentCreateRequest(int id, int postId, int userId, String text){
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
