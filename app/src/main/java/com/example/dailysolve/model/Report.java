package com.example.dailysolve.model;

public class Report {
    private int id;
    private String title;
    private String description;
    private String category;

    public Report(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }

    public void setId(int id) { this.id = id; }
}