package org.example;

import java.time.LocalDateTime;

public class Motivation {
    private int id;
    private LocalDateTime regDate;
    private String content;
    private String author;

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Motivation(LocalDateTime regDate, int id, String content, String author) {
        this.regDate = regDate;
        this.id = id;
        this.content = content;
        this.author = author;
    }
}
