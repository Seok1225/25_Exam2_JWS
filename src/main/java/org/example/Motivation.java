package org.example;

import java.time.LocalDateTime;

public class Motivation {
    private int id;
    private String content;
    private String author;
    private LocalDateTime regDate;

    public Motivation(int id, String content, String author, LocalDateTime regDate) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.regDate = regDate;
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public LocalDateTime getRegDate() { return regDate; }

    public void setContent(String content) { this.content = content; }
    public void setAuthor(String author) { this.author = author; }
}
