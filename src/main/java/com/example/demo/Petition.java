package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private int id;
    private String title;
    private String description;
    private List<String> signatures;

    public Petition(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getSignatures() { return signatures; }

    public void addSignature(String signature) {
        signatures.add(signature);
    }
}
