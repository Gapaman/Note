package com.example.note.model;


import java.io.Serializable;

public class NoteModel implements Serializable {

    private String id;
    private String title;
    private String description;
    private int backgroundColor;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}