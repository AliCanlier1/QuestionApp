package com.springbootproject.QuestionApp.requests;

public class LikeCreateRequest {

    private int userId;

    private int postId;

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LikeCreateRequest(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }
}
