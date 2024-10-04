package com.example.biografkinoofficial.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "showing", indexes = {
    @Index(name = "idx_showing_title", columnList = "title")
})
public class Showing {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
