package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private int id;
    private String title;
    private String description;
    private List<String> signatures;

    public Petition() {
        this.signatures = new ArrayList<>();
    }

    public Petition() {
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getSignatures() { return signatures; }

    // Setters
    public void setId(int id) { this.id=id; }
    public void setTitle(String title) { this.title=title; }
    public void setDescription(String description) { this.description=description; }
    public void addSignature(String signature) {
        signatures.add(signature);
    }
}
