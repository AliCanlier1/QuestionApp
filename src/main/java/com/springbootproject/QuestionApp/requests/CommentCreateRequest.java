package com.springbootproject.QuestionApp.requests;

public class CommentCreateRequest {

    private int postId;

    private int userId;

    private String text;

    public CommentCreateRequest(){}

    public CommentCreateRequest(int postId, int userId, String text){
        this.postId = postId;
        this.userId = userId;
        this.text = text;
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
