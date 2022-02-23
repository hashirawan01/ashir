package com.example.ashir;

public class Model_class {
    private int imagebox;
    private String title;
    private String body;

    public Model_class(int imagebox, String title, String body) {
        this.imagebox = imagebox;
        this.title = title;
        this.body = body;

    }

    public int getImagebox() {
        return imagebox;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
