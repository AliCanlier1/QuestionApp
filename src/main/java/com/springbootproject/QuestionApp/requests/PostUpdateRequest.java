package com.springbootproject.QuestionApp.requests;

public class PostUpdateRequest {

    private String text;
    private String title;

    public PostUpdateRequest() {
    }

    public PostUpdateRequest(String text, String title) {
        this.text = text;
        this.title = title;
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
}
