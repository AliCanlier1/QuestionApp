package com.springbootproject.QuestionApp.requests;


public class PostCreateRequest {

    private int id;
    private String text;
    private String title;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public PostCreateRequest() {
    }

    public PostCreateRequest(int id, String text, String title, int userId) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.userId = userId;
    }
}
